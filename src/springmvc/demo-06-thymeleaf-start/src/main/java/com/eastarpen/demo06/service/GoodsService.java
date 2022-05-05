package com.eastarpen.demo06.service;

import com.eastarpen.demo06.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAllGoods();

    List<Goods> queryGoodsByLimit(int limit, int offset);

    List<Goods> searchGoods(String[] keys, int limit, int offset);

    Goods queryGoodsById(int id);

    boolean deleteGoodsById(int id);

    boolean updateGoodsById(Goods goods);

    boolean addGoods(Goods goods);

    int getRecodeCount();

    int getSearchRecodeCount(String[] keys);
}
