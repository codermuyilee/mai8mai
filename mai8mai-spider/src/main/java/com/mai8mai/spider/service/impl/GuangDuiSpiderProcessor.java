package com.mai8mai.spider.service.impl;

import com.mai8mai.core.dao.model.Goods;
import com.mai8mai.spider.service.SpiderProcessor;
import com.mai8mai.core.util.DateStyle;
import com.mai8mai.core.util.DateUtil;
import com.mai8mai.spider.util.Constants;
import com.mai8mai.spider.util.DownloadResource;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GuangDuiSpiderProcessor implements SpiderProcessor {

    private static Logger logger = LoggerFactory.getLogger(GuangDuiSpiderProcessor.class);

    /**
     * 处理商品列表页
     *
     * @param url 处理商品列表页url
     */
    public List<Goods> spider(String url) {
        List<Goods> goodsList = new ArrayList<Goods>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("div.zkcontent div.gooditem.withborder");
            for (Element element : elements) {
                Goods goods = new Goods();
                String href = element.select("div.iteminfoarea h2.mallandname a.goodname").attr("href");
                if (!StringUtil.isBlank(href)) {
                    href = "http://guangdiu.com/" + href;
                    goods = detailPageProcess(href);
                }
                //商品id
                Pattern p = Pattern.compile("http://guangdiu\\.com/detail\\.php\\?id=(.*?)$");
                Matcher m = p.matcher(href);
                while (m.find()){
                    goods.setId(Long.parseLong(m.group(1)));
                    break;
                }

                //防止新的样式出现
                if(goods!=null){
                    //商品图片
                    String picUrl=element.select("div.imgandbtn div.showpic a img").attr("src");

                    p = Pattern.compile("(.*?)\\.com/(.*?)\\.jpg\\?(.*?)$");
                    m = p.matcher(picUrl);
                    while (m.find()){
                        goods.setPic(m.group(2)+".jpg");
                        break;
                    }

                    String [] urlArray=picUrl.split("/");
                    try {
                        DownloadResource.download(picUrl, goods.getPic(), Constants.PIC_SAVA_PATH);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //商品来源
                    String source=element.select("div.iteminfoarea div.timeandfrom div.infofrom").text();
                    goods.setSource(source);
                    Pattern pattern = Pattern.compile("自动从 ([0-9]*?)个来源网站 同步$");
                    Matcher matcher =pattern.matcher(source);
                    while (matcher.find()){
                        goods.setSourceNum(Integer.parseInt(matcher.group(1)));
                        break;
                    }
                    //商品更新时间html
                    String time=element.select("div.iteminfoarea div.timeandfrom div.infotime a").text();
                    if(time.contains("分钟")){
                        pattern = Pattern.compile("^([0-9]*?)分钟前$");
                        matcher =pattern.matcher(time);
                        while (matcher.find()){
                            goods.setSyncTime(DateUtil.addMinute(new Date(System.currentTimeMillis()), -Integer.parseInt(matcher.group(1))));
                            break;
                        }
                    }else if(time.contains("小时")){
                        pattern = Pattern.compile("^([0-9]*?)小时前$");
                        matcher =pattern.matcher(time);
                        while (matcher.find()){
                            goods.setSyncTime(DateUtil.addHour(new Date(System.currentTimeMillis()), -Integer.parseInt(matcher.group(1))));
                            break;
                        }
                    }else if(time.contains("昨天")){
                        pattern = Pattern.compile("^昨天(([0-9]|:)*?)$");
                        matcher =pattern.matcher(time);
                        while (matcher.find()){
                            String partTime=matcher.group(1);
                            String dateTime=DateUtil.DateToString(DateUtil.addDay(new Date(System.currentTimeMillis()), -1), DateStyle.YYYY_MM_DD);
                            goods.setSyncTime(DateUtil.StringToDate(dateTime + " " + partTime + ":00"));
                            break;
                        }
                    }
                    goodsList.add(goods);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    /**
     * 商品详情页处理
     *
     * @param url 商品详情页url
     * @return
     */
    private Goods detailPageProcess(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("div.detaildisplay");
            for (Element element : elements) {
                Goods goods = new Goods();
                //商品名称
                goods.setName(element.select("a.dtitle").text());
                //商品详情
                Elements detailElement = element.select("div#dabstract.dabstract p");
                StringBuffer detail = new StringBuffer();
                for (Element e : detailElement) {
                    detail.append(e.select("p").text() + "\n");
                }
                goods.setDetail(new String(detail));
                //若无数据，则用这个表达式进行抓取
                if(StringUtil.isBlank(goods.getDetail())){
                    goods.setDetail( element.select("div#dabstract.dabstract").text());
                }
                //商品购买网址
                String href = "http://guangdiu.com/" + element.select("a.dgotobutton").attr("href");
                goods.setGotoBuyUrl(href);
                return goods;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
