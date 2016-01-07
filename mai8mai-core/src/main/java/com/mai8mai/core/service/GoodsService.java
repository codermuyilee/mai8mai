package com.mai8mai.core.service;

import com.mai8mai.core.dao.model.Goods;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface GoodsService {
    public boolean create(Goods goods);
    public Goods getGoodsById(Long id);
}
