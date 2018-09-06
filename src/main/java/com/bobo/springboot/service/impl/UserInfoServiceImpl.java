package com.bobo.springboot.service.impl;

import com.bobo.springboot.exception.IllegalParameterException;
import com.bobo.springboot.mapper.UserInfoMapper;
import com.bobo.springboot.entity.UserInfo;
import com.bobo.springboot.param.UserInfoQueryParam;
import com.bobo.springboot.service.UserInfoService;;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int save(UserInfo entity) {
        return userInfoMapper.insert(entity);
    }

    @Override
    public int update(UserInfo entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
            throw new IllegalParameterException("更新内容id不能为空");
        }

        return userInfoMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
            throw new IllegalParameterException("删除操作id不能为空");
        }


        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserInfo getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
            throw new IllegalParameterException("详情id不能为空");
        }

        return userInfoMapper.selectByPrimaryKey(id);
    }

    // 分页方法
    @Override
    public PageInfo<UserInfo> pageQuery(UserInfoQueryParam queryParam) {
        // ps pn 都是公共查询方法力的参数   这是分页插件 很好用的插件～
        PageHelper.startPage(queryParam.getPn(), queryParam.getPs());
        // 自己在mapper里定义的查询集合方法
        List<UserInfo> list = userInfoMapper.listQuery(queryParam);
        PageInfo<UserInfo> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<UserInfo> listQuery(UserInfoQueryParam queryParam) {
        return userInfoMapper.listQuery(queryParam);
    }
}

