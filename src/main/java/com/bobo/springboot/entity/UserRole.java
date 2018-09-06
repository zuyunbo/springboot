package com.bobo.springboot.entity;

import com.bobo.springboot.common.BaseEntity;

/**
 *  角色与用户关联表
 */
public class UserRole extends BaseEntity {

    private Integer userId;

    private Integer roleId;


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
}

