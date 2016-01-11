package com.mai8mai.core.service;

import com.mai8mai.core.beans.Page;
import com.mai8mai.core.dao.model.Goods;

import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface GoodsService {
    public boolean create(Goods goods);
    public Goods getGoodsById(Long id);

    /**
     * 分页查询，目前还不知道前端需要哪些参数，暂定只有分页信息
     * @param page
     * @return
     */
    public List<Goods> getGoodsByPage(Page page);
}
