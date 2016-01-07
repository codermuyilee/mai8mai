package com.mai8mai.spider.main;

import com.alibaba.fastjson.JSON;
import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.core.service.GoodsService;
import com.mai8mai.core.util.ApplicationContextUtils;
import com.mai8mai.spider.impl.GuangDuiSpiderProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/7.
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(GuangDuiSpiderProcessor.class);

    public static void main(String[] args) {
        GoodsService goodsService= (GoodsService)ApplicationContextUtils.getBean(GoodsService.class);
        GuangDuiSpiderProcessor p = new GuangDuiSpiderProcessor();
        int pageSize = 82;
        for (int i = 80; i < pageSize; i++) {
            String url = String.format("http://guangdiu.com/index.php?p=%d", i);
            List<Goods> goodsList = p.spider(url);
            Map<String, String> goodsMap = new HashMap<String, String>();
            for (Goods goods : goodsList) {
                goods.setCreateTime(new Date(System.currentTimeMillis()));
                goodsService.create(goods);
                logger.info(JSON.toJSONString(goods));
            }
        }

    }
}
