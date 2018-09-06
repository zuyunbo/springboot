package com.bobo.springboot.mapper;
import com.bobo.springboot.entity.UserInfo;
import com.bobo.springboot.param.UserInfoQueryParam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Repository
public interface UserInfoMapper extends  Mapper<UserInfo>  {

 List<UserInfo> listQuery(UserInfoQueryParam queryParam);

}

