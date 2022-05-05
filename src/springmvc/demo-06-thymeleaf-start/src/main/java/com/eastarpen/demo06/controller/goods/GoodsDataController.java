package com.eastarpen.demo06.controller.goods;

import com.eastarpen.demo06.entity.Goods;
import com.eastarpen.demo06.service.GoodsService;
import com.eastarpen.demo06.utils.Constant;
import com.eastarpen.demo06.utils.OperationResult;
import com.eastarpen.demo06.utils.RequestGoods;
import com.eastarpen.demo06.utils.TablePaginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("data")
public class GoodsDataController {

    private GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("table")
    public String tableData(@Nullable @RequestParam("limit") Integer limit, @Nullable @RequestParam("offset") Integer offset,
                            HttpServletRequest req) {
        if(null == limit) {
            limit = 0; offset = 0;
        }
        String keys[] = (String[]) req.getSession().getAttribute("keys");
        TablePaginate<Goods> tablePaginate = null;
        if(null != keys) {
            tablePaginate = searchResult(keys, req, limit, offset);
        } else {
            tablePaginate = result(req, limit, offset);
        }
        return tablePaginate.toString();
    }

    @PostMapping("add")
    public String addResult(HttpServletRequest req) {
        Goods goods = RequestGoods.getGoods(req);
        boolean flag = goodsService.addGoods(goods);
        if(flag) {
            updateTotal(1, req);
        }
        return new OperationResult(Constant.ADD, flag).toString();
    }

    @PostMapping("update")
    public String updateResult(HttpServletRequest req) {
        Goods goods = RequestGoods.getGoods(req);
        return new OperationResult(Constant.ADD, goodsService.updateGoodsById(goods)).toString();
    }

    @GetMapping("delete")
    public String deleteResult(@RequestParam("id") int id, HttpServletRequest req) {
        boolean flag = goodsService.deleteGoodsById(id);
        if(flag) {
            updateTotal(-1, req);
        }
        return new OperationResult(Constant.ADD, flag).toString();
    }

    private TablePaginate<Goods> result(HttpServletRequest req, int limit, int offset) {
        int total = 0;
        try{
            total = (int) req.getSession().getAttribute("total");
        } catch (Exception e) {
            e.printStackTrace();
            total = goodsService.getRecodeCount();
            req.getSession().setAttribute("total", total);
        }
        List<Goods> goodsList = goodsService.queryGoodsByLimit(limit, offset);
        return new TablePaginate<Goods>(total, goodsList);
    }

    private TablePaginate<Goods> searchResult(String[] keys, HttpServletRequest req,
                                              int limit, int offset) {
        int searchTotal = 0;
        try{
            searchTotal = (int) req.getSession().getAttribute("searchTotal");
        } catch (Exception e) {
            e.printStackTrace();
            searchTotal = goodsService.getSearchRecodeCount(keys);
            req.getSession().setAttribute("searchTotal", searchTotal);
        }
        List<Goods> goodsList = goodsService.searchGoods(keys, limit, offset);
        return new TablePaginate<Goods>(searchTotal, goodsList);
    }

    private void updateTotal(int step, HttpServletRequest req) {
        int total = (int) req.getSession().getAttribute("total");
        req.getSession().setAttribute("total", total+step);
    }
}
