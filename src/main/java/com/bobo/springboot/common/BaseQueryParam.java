package com.bobo.springboot.common;

/**
 * 公共查询类
 */
public class BaseQueryParam {

    private int ps;   //每页行数

    private int pn;   //当前页数

    /**
     * 还可以加一些常用的查询参数 ，用于统一规范处理
     * 如: private String creDate;
     */


    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }
}
