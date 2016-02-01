package com.mai8mai.core.service;

import com.mai8mai.core.dao.model.Cart;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface CartService {
    public boolean create(Cart cart);
    public boolean edit(Cart cart);
    public Cart getCartById(Long id);
}
