package com.mai8mai.core.service.impl;

import com.mai8mai.core.dao. CartItemDao;
import com.mai8mai.core.dao.model. CartItem;
import com.mai8mai.core.service. CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/1/6.
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class CartItemServiceImpl implements  CartItemService {

    @Autowired
    private  CartItemDao  CartItemDao;

    public boolean create( CartItem  CartItem) {
        try {
             CartItemDao.create( CartItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean edit( CartItem  CartItem) {
        try {
             CartItemDao.edit( CartItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CartItem getCartItemById(Long id) {
         CartItem  CartItem= CartItemDao.find(id);
        return  CartItem;
    }

    public  CartItemDao getCartItemDao() {
        return  CartItemDao;
    }

    public void setCartItemDao( CartItemDao  CartItemDao) {
        this. CartItemDao =  CartItemDao;
    }

}
