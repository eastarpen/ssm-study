package com.eastarpen.demo06.controller.goods;

import com.eastarpen.demo06.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsViewController {

    private GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("manage")
    public String displayGoodsView(@Nullable @RequestParam("key") String key,
            Model model, HttpServletRequest request) {
        String title = null;
        if(null != key) {
            title = "搜索结果";
            String[] keys = key.split("\\s+");
            request.getSession().setAttribute("keys", keys);
            request.getSession().removeAttribute("searchTotal");
        } else {
            request.getSession().removeAttribute("keys");
            title = "全部商品";
        }
        model.addAttribute("title", title);
        return "goods/goodsTable";
    }

    @GetMapping("manage/add")
    public String addGoodsView(Model model) {
        model.addAttribute("title", "添加商品");
        return "goods/singleGoods";
    }

    @GetMapping("manage/update/{id}")
    public String updateGoodsView(@PathVariable("id") int id,  Model model) {
        model.addAttribute("title", "更新商品信息");
        model.addAttribute("goods", goodsService.queryGoodsById(id));
        return "goods/singleGoods";
    }
}
