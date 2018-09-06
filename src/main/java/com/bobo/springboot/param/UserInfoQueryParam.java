package com.bobo.springboot.param;

import com.bobo.springboot.common.BaseQueryParam;


public class UserInfoQueryParam extends BaseQueryParam {
    //按照用户名查询
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

