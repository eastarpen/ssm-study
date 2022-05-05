package com.eastarpen.demo06.utils;

import com.eastarpen.demo06.entity.Goods;

import javax.servlet.http.HttpServletRequest;

public class RequestGoods {

    public static Goods getGoods(HttpServletRequest req) {
        return new Goods(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("type"),
                req.getParameter("origin"),
                Double.parseDouble(req.getParameter("price")),
                StringToDate.stringToDate(req.getParameter("productionDate"))
        );
    }
}
