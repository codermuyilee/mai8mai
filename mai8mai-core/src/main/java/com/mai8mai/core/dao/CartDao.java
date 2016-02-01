package com.mai8mai.core.dao;

import com.mai8mai.core.dao.model.Cart;
import com.mai8mai.core.dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CartDao extends AbstractDao<Cart> {

    private static final Logger logger = LoggerFactory.getLogger(CartDao.class);

    public CartDao() {
        super(Cart.class);
    }

}
