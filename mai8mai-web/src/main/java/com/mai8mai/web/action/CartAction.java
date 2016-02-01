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
@Namespace("/user")
public class CartAction extends ActionSupport {

    final static private Logger logger = LoggerFactory.getLogger(CartAction.class);



    /**
     * @return the message
     */
    @Action(value = "home")
    public String getCartByUserId() {
        return "goods_list";
    }


}