package com.bobo.springboot.service.impl;

import com.bobo.springboot.exception.IllegalParameterException;
import com.bobo.springboot.mapper.RoleInfoMapper;
import com.bobo.springboot.entity.RoleInfo;
import com.bobo.springboot.param.RoleInfoQueryParam;
import com.bobo.springboot.service.RoleInfoService;;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author zuß
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    RoleInfoMapper roleInfoMapper;

    @Override
    public int save(RoleInfo entity) {
        return roleInfoMapper.insert(entity);
    }

    @Override
    public int update(RoleInfo entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            throw new IllegalParameterException("更新内容id不能为空");
        }

        return roleInfoMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("删除操作id不能为空");
        }

        return roleInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RoleInfo getById(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("详情id不能为空");
        }





        return roleInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<RoleInfo> pageQuery(RoleInfoQueryParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> roleInfoMapper.listQuery(queryParam));
    }

    @Override
    public List<RoleInfo> listQuery(RoleInfoQueryParam queryParam) {
        return roleInfoMapper.listQuery(queryParam);
    }
}

