package com.bobo.springboot.mapper;

import com.bobo.springboot.param.UserRoleQueryParam;
import com.bobo.springboot.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface UserRoleMapper extends Mapper<UserRole> {

    List<UserRole> listQuery(UserRoleQueryParam queryParam);

}

