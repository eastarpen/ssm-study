package com.eastarpen.demo06.dao;

import com.eastarpen.demo06.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    private static RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public User queryUserById(int id) {
        String sql = "SELECT * FROM javaee.user WHERE id=?;";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User queryUserByName(String name) {
        String sql = "SELECT * FROM javaee.user WHERE name=?;";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, rowMapper, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
