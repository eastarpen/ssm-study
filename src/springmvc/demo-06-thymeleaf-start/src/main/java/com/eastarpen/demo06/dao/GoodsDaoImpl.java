package com.eastarpen.demo06.dao;

import com.eastarpen.demo06.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {

    private JdbcTemplate jdbcTemplate;

    private static RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Goods> queryAll() {
        String sql = "SELECT * FROM javaee.goods;";
        List<Goods> goodsList = null;
        try {
            goodsList = jdbcTemplate.query(sql, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public Goods queryGoodsById(int id) {
        String sql = "SELECT * FROM javaee.goods WHERE id=?;";
        Goods goods = null;
        try {
            goods = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Goods> queryGoodsUsingLimit(int limit, int offset) {
        String sql = "SELECT * FROM javaee.goods LIMIT ? OFFSET ?;";
        List<Goods> goodsList = null;
        try {
            goodsList = jdbcTemplate.query(sql, rowMapper, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public List<Goods> searchGoods(String[] keys, int limit, int offset) {
        List<Goods> goodsList = null;
        String sql = getSearchSql(keys, limit > 0);
        try {
            if(limit > 0 ) {
                goodsList = jdbcTemplate.query(sql, rowMapper, limit, offset);
            } else {
                goodsList = jdbcTemplate.query(sql, rowMapper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsList;
    }
    public List<Goods> searchGoods(String[] keys) {
        return searchGoods(keys, -1, 0);
    }

    @Override
    public int addGoods(Goods goods) {
        String sql = "INSERT INTO javaee.goods " +
                "(`name`, `type`, `origin`, `price`, `productionDate`) " +
                "VALUES " +
                "(?, ?, ?, ?, ?);";
        int res = 0;
        try {
           res = jdbcTemplate.update(sql, goods.getName(), goods.getType(), goods.getOrigin(),
                   goods.getPrice(), goods.getProductionDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteGoodsById(int id) {
        String sql = "DELETE FROM javaee.goods WHERE id = ?;";
        int res = 0;
        try {
            res = jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateGoodsById(Goods goods) {
        String sql = "UPDATE javaee.goods SET " +
                "`name`=?, `type`=?, `origin`=?, `price`=?, `productionDate`=? " +
                "WHERE id=?;";
        int res = 0;
        try {
            res = jdbcTemplate.update(sql, goods.getName(), goods.getType(), goods.getOrigin(),
                    goods.getPrice(), goods.getProductionDate(), goods.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int getRecodeCount() {
        String sql = "SELECT COUNT(id) FROM javaee.goods;";
        int res = 0;
        try {
            res = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int getSearchRecodeCount(String[] keys) {
        return searchGoods(keys).size();
    }

    /**
     * called by method searchGoods, return search sql
     * @param keys
     * @param hasLimit
     * @return
     */
    private String getSearchSql(String[] keys, boolean hasLimit) {
        String sql =  "SELECT `id`, `name`, `type`, `origin`, `price`, `productionDate` " +
                "FROM " +
                "(SELECT *, CONCAT(`id`, `name`, `type`, `origin`, `price`, `productionDate`) AS s FROM goods) t";
        for (String key : keys) {
            if(key.equals(keys[0])) {
                sql += " WHERE";
            } else {
                sql += " AND";
            }
            sql += String.format(" t.s LIKE '%%%s%%'", key);
        }
        for (String key : keys) {
            if(key.equals(keys[0])) {
                sql += " ORDER BY CASE";
            }
            String ke = String.format("'%%%s%%'", key);
            sql += String.format(" WHEN t.s LIKE %s THEN length(REPLACE(t.s, %s, ''))/length(t.s)", ke, ke);
            if(key.equals(keys[keys.length-1])) {
                sql += " END";
            }
        }
        if(hasLimit) {
            sql += " LIMIT ? OFFSET ?;";
        }
        return sql;
    }
}
