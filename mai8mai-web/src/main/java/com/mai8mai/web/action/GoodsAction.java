package com.mai8mai.web.action;

import com.mai8mai.core.beans.Page;
import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.core.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Results({@Result(name = "success", location = "/msg.jsp"),
        @Result(name = "error", location = "/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
@Namespace("/goods")
public class GoodsAction extends ActionSupport {

    final static private Logger logger = LoggerFactory.getLogger(GoodsAction.class);

    private Goods goods;
    private Long id;
    private Page page=new Page();
    private List<Goods> goodsList;
    @Autowired
    private GoodsService goodsService;

    /**
     * @return the message
     */
    @Action(value = "home")
    public String home() {

        goodsList=goodsService.getGoodsByPage(page);
        return "goods_list";
    }


    /**商品列表，竖向视图
     * @return the message
     */
    @Action(value = "list_v")
    public String list_v() {
        goodsList=goodsService.getGoodsByPage(page);
        return "goods_list_v";
    }

    /**
     * @return the message
     */
    @Action(value = "get")
    public String get() {
        goods=goodsService.getGoodsById(id);
        return "goods_page";
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page){
        this.page=page;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}