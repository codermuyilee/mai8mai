package com.mai8mai.service.impl;

import com.mai8mai.dao.GoodsDao;
import com.mai8mai.dao.model.Goods;
import com.mai8mai.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/1/6.
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public Goods getGoodsById(Long id) {
        Goods goods=goodsDao.find(1L);
        if(goods==null){
            goods=new Goods();
            goods.setId(1L);
            goods.setName("hello 6s");
            try {
                goodsDao.create(goods);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return goods;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

}
