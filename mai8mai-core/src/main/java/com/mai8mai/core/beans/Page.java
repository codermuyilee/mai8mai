package com.mai8mai.core.beans;

/**
 * Created by Administrator on 2016/1/11.
 */
public class Page {

    private int pageSize=30;
    private int pageNum=1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
