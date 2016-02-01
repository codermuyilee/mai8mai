package com.mai8mai.core.dao;

import com.mai8mai.core.dao.model.Cart;
import com.mai8mai.core.dao.model.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CartItemDao extends AbstractDao<CartItem> {

    private static final Logger logger = LoggerFactory.getLogger(CartItemDao.class);

    public CartItemDao() {
        super(CartItem.class);
    }

}
