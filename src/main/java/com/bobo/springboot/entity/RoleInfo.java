package com.bobo.springboot.entity;

import com.bobo.springboot.common.BaseEntity;

/**
 * 角色实体
 */
public class RoleInfo extends BaseEntity {

    private String name;

    private String description;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

