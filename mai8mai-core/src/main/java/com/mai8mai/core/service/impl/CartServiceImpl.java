package com.mai8mai.core.service.impl;

import com.mai8mai.core.dao.CartDao;
import com.mai8mai.core.dao.model.Cart;
import com.mai8mai.core.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/1/6.
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public boolean create(Cart Cart) {
        try {
            cartDao.create(Cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean edit(Cart Cart) {
        try {
            cartDao.edit(Cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cart getCartById(Long id) {
        Cart Cart=cartDao.find(id);
        return Cart;
    }

    public CartDao getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartDao CartDao) {
        this.cartDao = CartDao;
    }

}
