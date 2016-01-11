package com.mai8mai.core.service.impl;

import com.mai8mai.core.beans.Page;
import com.mai8mai.core.dao.GoodsDao;
import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.core.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public boolean create(Goods goods) {
        try {
            goodsDao.create(goods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Goods getGoodsById(Long id) {
        Goods goods=goodsDao.find(id);
        return goods;
    }

    public List<Goods> getGoodsByPage(Page page) {
        Query query = goodsDao.getEntityManager().createQuery("from Goods g order by g.syncTime desc ");
        List list = query.setMaxResults(page.getPageSize()).setFirstResult(page.getPageNum()-1).getResultList();
        return list;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

}
