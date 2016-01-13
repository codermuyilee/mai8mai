package com.mai8mai.spider.service;

import com.mai8mai.core.dao.model.Goods;

import java.util.List;

/**
 * Created by Administrator on 2016/1/7.
 */
public interface SpiderProcessor {
    public List<Goods> spider(String url);

    /**
     * 根据主站url获得需要抓取的所有具体的url地址
     * @param url
     * @return
     */
    public List<String> spiderPageUrl(String url);
}
