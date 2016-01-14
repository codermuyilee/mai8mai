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

import java.util.*;

/**
 * Created by yangli on 2016/1/13.
 */
public class XiaoHongShuSpiderProcessor implements SpiderProcessor {

    private static Logger logger = LoggerFactory.getLogger(XiaoHongShuSpiderProcessor.class);

    private static  String XIAOHONGSHU_CATEGORY_URL="http://www.xiaohongshu.com/api/store/v1/banners?oid=%s";

    //首页推荐商品url
    private static String XIAOHONGSHU_RECOMMEND_URL="http://www.xiaohongshu.com/api/store/v1/banners/%s";

    public List<Goods> spider(String url) {


        return null;
    }

    public List<String> spiderPageUrl(String url){
        List<String> urls=new ArrayList<String>();
        try {
            String result=HttpclientUtil.get(url);
            JSONObject jsonObject=JSONObject.parseObject(result);
            JSONArray data=jsonObject.getJSONArray("data");
            for (Object b:data){
                JSONObject object=(JSONObject) b;
                String id=object.getString("id");
                urls.add(String.format(XIAOHONGSHU_CATEGORY_URL, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获得小红伞各个类别页面url出错");
        }
        logger.debug(JSON.toJSONString(urls));
        return urls;
    }

    /**
     * 获得首页推荐分类的url
     * @param url
     * @return
     */
    public List<String> spiderRecommendPageUrl(String url){
        List<String> urls=new ArrayList<String>();
        try {
            String httpResult=httpResult = HttpclientUtil.get(url);
            JSONObject jsonObject=JSONObject.parseObject(httpResult);
            JSONArray data=jsonObject.getJSONArray("data");
            for (Object o:data){
                JSONObject goodsJSONObject=(JSONObject)o;
                urls.add(String.format(XIAOHONGSHU_RECOMMEND_URL, goodsJSONObject.getString("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(JSON.toJSONString(urls));
        return urls;
    }

    public static void main(String[] args) {
        GoodsService goodsService= (GoodsService) ApplicationContextUtils.getBean(GoodsService.class);
        String url="http://www.xiaohongshu.com/api/store/v1/categories?deviceId=36967ACB-05C5-49AB-90FF-10C0808F4D3A&lang=zh-Hans-CN&platform=iOS&sid=session.1133027313307848064&sign=561f66a7cf9dc8daf810ca8b3858c7b0&t=1452677216";
        SpiderProcessor p = new XiaoHongShuSpiderProcessor();
        List<String> urls=p.spiderPageUrl(url);
        for (String u:urls){
            List<Goods> goodses=p.spider(u);
        }
    }
}
