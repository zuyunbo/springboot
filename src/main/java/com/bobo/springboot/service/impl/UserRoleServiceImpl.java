package com.bobo.springboot.service.impl;

import com.bobo.springboot.exception.IllegalParameterException;
import com.bobo.springboot.mapper.UserRoleMapper;
import com.bobo.springboot.entity.UserRole;
import com.bobo.springboot.param.UserRoleQueryParam;
import com.bobo.springboot.service.UserRoleService;;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zu
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int save(UserRole entity) {
        return userRoleMapper.insert(entity);
    }

    @Override
    public int update(UserRole entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            throw new IllegalParameterException("更新内容id不能为空");
        }

        return userRoleMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("删除操作id不能为空");
        }

        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserRole getById(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("详情id不能为空");
        }

        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<UserRole> pageQuery(UserRoleQueryParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> userRoleMapper.listQuery(queryParam));
    }

    @Override
    public List<UserRole> listQuery(UserRoleQueryParam queryParam) {
        return userRoleMapper.listQuery(queryParam);
    }
}

