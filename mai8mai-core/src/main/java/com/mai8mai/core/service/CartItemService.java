package com.mai8mai.core.service;

import com.mai8mai.core.dao.model.Cart;
import com.mai8mai.core.dao.model.CartItem;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface CartItemService {
    public boolean create( CartItem cartItem);
    public boolean edit( CartItem cartItem);
    public CartItem getCartItemById(Long id);
}
