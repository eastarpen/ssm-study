package com.eastarpen.demo06.dao;

import com.eastarpen.demo06.entity.Goods;
import com.eastarpen.demo06.utils.StringToDate;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GoodsDaoImplTest {
    GoodsDao goodsDao = new ClassPathXmlApplicationContext("applicationContext.xml")
            .getBean("goodsDaoImpl", GoodsDao.class);

    @Test
    public void queryAll() {

        List<Goods> goodsList = goodsDao.queryAll();
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void queryGoodsById() {
        System.out.println(goodsDao.queryGoodsById(100));
    }

    @Test
    public void queryGoodsUsingLimit() {
        List<Goods> goodsList = goodsDao.queryGoodsUsingLimit(10, 1);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void searchGoods() {
        String keys[] = {"origin", "1"};
        List<Goods> goodsList = goodsDao.searchGoods(keys, 5, 0);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void addGoods() {
        Goods goods = new Goods(-1, "addTest", "test", "test", 12.1,
                StringToDate.stringToDate("2020-11-11"));
        System.out.println(goodsDao.addGoods(goods));
    }

    @Test
    public void deleteGoodsById() {
        System.out.println(goodsDao.deleteGoodsById(103));
        System.out.println(goodsDao.queryGoodsById(103));
    }

    @Test
    public void updateGoodsById() {
        Goods goods = new Goods(102, "updateTest", "updateTest", "updateTest", 12.1,
                StringToDate.stringToDate("2020-11-11"));
        System.out.println(goodsDao.updateGoodsById(goods));
        String keys[] = {"updateTest", "102"};
        List<Goods> goodsList = goodsDao.searchGoods(keys, 5, 0);
        for (Goods goods2 : goodsList) {
            System.out.println(goods2);
        }

    }

    @Test
    public void getRecodeCount() {
        System.out.println(goodsDao.getRecodeCount());
    }

    @Test
    public void getSearchRecodeCount() {
        String[] keys = {"test"};
        System.out.println(goodsDao.getSearchRecodeCount(keys));
    }
}