package com.mai8mai.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name="goods")
public class Goods extends BaseModel {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品介绍
     */
    private String detail;
    /**
     * 管丢详情页
     */
    private String detailUrl;
    /**
     * 购买链接
     */
    private String gotoBuyUrl;
    /**
     * 图
     */
    private String pic;
    /**
     * 信息来源站点
     */
    private String source;

    /**
     * 信息来源站点
     */
    private int sourceNum=1;
    /**
     * 同步时间
     */
    private Date syncTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="sync_time")
    @Temporal(TIMESTAMP)
    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }
    @Column(name="detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Column(name="detail_url")
    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    @Column(name="goto_buy_url")
    public String getGotoBuyUrl() {
        return gotoBuyUrl;
    }

    public void setGotoBuyUrl(String gotoBuyUrl) {
        this.gotoBuyUrl = gotoBuyUrl;
    }

    @Column(name="pic")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Column(name="source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name="source_num")
    public int getSourceNum() {
        return sourceNum;
    }

    public void setSourceNum(int sourceNum) {
        this.sourceNum = sourceNum;
    }

    @Column(name = "create_time")
    @Temporal(TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    @Temporal(TIMESTAMP)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
