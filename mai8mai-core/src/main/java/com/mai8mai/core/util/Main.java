package com.mai8mai.core.util;

import com.mai8mai.core.dao.model.Cart;
import com.mai8mai.core.dao.model.User;
import com.mai8mai.core.service.CartItemService;
import com.mai8mai.core.service.CartService;
import com.mai8mai.core.service.GoodsService;
import com.mai8mai.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/1/7.
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        GoodsService goodsService= (GoodsService)ApplicationContextUtils.getBean(GoodsService.class);
        goodsService.getGoodsById(123L);

        UserService userService= (UserService)ApplicationContextUtils.getBean(UserService.class);
        User user=userService.getUserById(1L);
        Cart cart=new Cart();
        cart.setUser(user);
        user.setCart(cart);
        userService.edit(user);


        CartService cartService= (CartService)ApplicationContextUtils.getBean(CartService.class);

        CartItemService cartItemService= (CartItemService)ApplicationContextUtils.getBean(CartItemService.class);

    }
}
