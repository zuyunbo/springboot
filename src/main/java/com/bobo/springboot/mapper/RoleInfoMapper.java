package com.bobo.springboot.mapper;

import com.bobo.springboot.entity.RoleInfo;
import com.bobo.springboot.param.RoleInfoQueryParam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;


@Repository
public interface RoleInfoMapper extends Mapper<RoleInfo> {

    List<RoleInfo> listQuery(RoleInfoQueryParam queryParam);

}

