package com.bobo.springboot.service;

import com.bobo.springboot.common.BaseServiceInterface;
import com.bobo.springboot.entity.UserInfo;
import com.bobo.springboot.param.UserInfoQueryParam;


public interface UserInfoService extends BaseServiceInterface<UserInfo,UserInfoQueryParam,Long> {
}

