package com.eastarpen.demo06.service;

import com.eastarpen.demo06.dao.GoodsDao;
import com.eastarpen.demo06.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    private GoodsDao goodsDao;

    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAll();
    }

    @Override
    public List<Goods> queryGoodsByLimit(int limit, int offset) {
        if(0 == limit) return goodsDao.queryAll();
        return goodsDao.queryGoodsUsingLimit(limit, offset);
    }

    @Override
    public List<Goods> searchGoods(String[] keys, int limit, int offset) {
        if(keys == null || keys.length == 0) return goodsDao.queryAll();
        return goodsDao.searchGoods(keys, limit, offset);
    }

    @Override
    public Goods queryGoodsById(int id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public boolean deleteGoodsById(int id) {
        return 1 == goodsDao.deleteGoodsById(id);
    }

    @Override
    public boolean updateGoodsById(Goods goods) {
        return 1 == goodsDao.updateGoodsById(goods);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return 1 == goodsDao.addGoods(goods);
    }

    @Override
    public int getRecodeCount() {
        return goodsDao.getRecodeCount();
    }

    @Override
    public int getSearchRecodeCount(String[] keys) {
        return goodsDao.getSearchRecodeCount(keys);
    }
}
