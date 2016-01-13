package com.mai8mai.spider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.core.service.GoodsService;
import com.mai8mai.core.util.ApplicationContextUtils;
import com.mai8mai.core.util.HttpclientUtil;
import com.mai8mai.spider.service.SpiderProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangli on 2016/1/13.
 */
public class XiaoHongShuSpiderProcessor implements SpiderProcessor {

    private static Logger logger = LoggerFactory.getLogger(XiaoHongShuSpiderProcessor.class);

    @Override
    public List<Goods> spider(String url) {
        return null;
    }

    public List<String> spiderPageUrl(String url){
        try {
            String result=HttpclientUtil.get(url);
            JSONObject jsonObject=JSONObject.parseObject(result);
            JSONArray data=jsonObject.getJSONArray("data");
            for (Object b:data){
                JSONObject object=(JSONObject) b;
                String id=object.getString("id");
                String name=object.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获得小红伞各个类别页面url出错");
        }
        return null;
    }
    public static void main(String[] args) {
        GoodsService goodsService= (GoodsService) ApplicationContextUtils.getBean(GoodsService.class);
        String url="http://www.xiaohongshu.com/api/store/v1/categories?deviceId=36967ACB-05C5-49AB-90FF-10C0808F4D3A&lang=zh-Hans-CN&platform=iOS&sid=session.1133027313307848064&sign=561f66a7cf9dc8daf810ca8b3858c7b0&t=1452677216";
        SpiderProcessor p = new XiaoHongShuSpiderProcessor();
        List<String> urls=p.spiderPageUrl(url);

        /*int pageSize = 10;
        for (int i = 1; i < pageSize; i++) {
            String url = String.format("http://guangdiu.com/index.php?p=%d", i);
            List<Goods> goodsList = p.spider(url);
            Map<String, String> goodsMap = new HashMap<String, String>();
            for (Goods goods : goodsList) {
                goods.setCreateTime(new Date(System.currentTimeMillis()));
                goodsService.create(goods);
                // logger.info(JSON.toJSONString(goods));
            }
        }
*/
    }
}
