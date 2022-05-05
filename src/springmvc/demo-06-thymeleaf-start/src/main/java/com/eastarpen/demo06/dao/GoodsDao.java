package com.eastarpen.demo06.dao;

import com.eastarpen.demo06.entity.Goods;

import java.util.List;

public interface GoodsDao {

    List<Goods> queryAll();

    Goods queryGoodsById(int id);

    List<Goods> queryGoodsUsingLimit(int limit, int offset);

    List<Goods> searchGoods(String[] keys, int limit, int offset);

    int addGoods(Goods goods);

    int deleteGoodsById(int id);

    int updateGoodsById(Goods goods);

    int getRecodeCount();

    int getSearchRecodeCount(String[] keys);
}
