package com.mai8mai.service.impl;

import com.mai8mai.dao.model.Goods;
import com.mai8mai.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/6.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    public Goods getGoodsById(Long id) {
        Goods Goods=new Goods();
        Goods.setName("apple 6s");
        return Goods;
    }
}
