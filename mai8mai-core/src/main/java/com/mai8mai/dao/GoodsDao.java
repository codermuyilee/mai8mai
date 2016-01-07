package com.mai8mai.dao;

import com.mai8mai.dao.model.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;


@Repository
public class GoodsDao extends AbstractDao<Goods> {

    private static final Logger logger = LoggerFactory.getLogger(GoodsDao.class);


    public GoodsDao() {
        super(Goods.class);
    }


    /**
     * 根据奇谱id获得Goods
     *
     * @param id
     * @return
     */
    public Goods getGoodsByQipuId(Long id) {
        if (id == null) {
            return null;
        }
        String sql = "select a from Goods a where a.qipuId= ?1";
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, id);
        try {
            return (Goods) query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("The qipuId {} does not exist", id);
            return null;
        }
    }

}
