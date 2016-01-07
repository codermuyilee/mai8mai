package com.mai8mai.web.action;

import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.core.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Results({@Result(name = "success", location = "/msg.jsp"),
        @Result(name = "error", location = "/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
public class GoodsAction extends ActionSupport {

    final static private Logger logger = LoggerFactory.getLogger(GoodsAction.class);

    private Goods goods;
    private Long id;
    @Autowired
    private GoodsService goodsService;

    /**
     * @return the message
     */
    @Action(value = "home")
    public String home() {
        goods=goodsService.getGoodsById(id);
        return "home";
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}