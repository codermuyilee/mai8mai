package com.mai8mai.web.action;

import com.mai8mai.dao.model.Goods;
import com.mai8mai.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// 父包

@Results({@Result(name = "success", location = "/msg.jsp"),
        @Result(name = "error", location = "/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
public class HelloWorld extends ActionSupport {

    final static private Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    private String message;

    @Autowired
    private GoodsService goodsService;

    /**
     * @return the message
     */
    @Action(value = "hello", results = {@Result(name = "success", location = "/HelloWorld.jsp")})
    public String hello() {
        Goods goods=goodsService.getGoodsById(1L);
        message=goods.getName();
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}