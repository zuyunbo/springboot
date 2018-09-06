package com.bobo.springboot.controller;

import com.bobo.springboot.common.BaseResponseUtil;
import com.bobo.springboot.param.UserInfoQueryParam;
import com.bobo.springboot.service.UserInfoService;
import com.bobo.springboot.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 以前的项目如果想要让方法返回json格式的 就需要在每个方法之上定义@ResponseBody 注解

// 由于在RestController注解中包含 @Controller @ResponseBody 双注解 就不需要在每个方法上定义@ResponseBody注解

@RestController
@RequestMapping("/user/userInfo")  // 获取url控制 如：localhost:8080/user/userInfo 就会访问到本类中
public class UserInfoController {

    // 本次url是请求适用于restful 风格 所以请求方法会有一点变化 并不是以前的GetMapping()

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/save")  //restful 风格的 如果不懂可以先去了解一下
    public Object save(@RequestBody UserInfo entity) {
        int result = userInfoService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @GetMapping(value = "/{id}/detail")  //restful 风格的 如果不懂可以先去了解一下
    public Object detail(@PathVariable long id) {
        UserInfo entity = userInfoService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }

    @PutMapping(value = "/update")    //restful 风格的 如果不懂可以先去了解一下
    public Object update(@RequestBody UserInfo entity) {
        int result = userInfoService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }

    @DeleteMapping(value = "/{id}")   //restful 风格的 如果不懂可以先去了解一下
    public Object remove(@PathVariable long id) {
        int result = userInfoService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }

    @GetMapping(value = "/list")    //restful 风格的 如果不懂可以先去了解一下
    public Object list(UserInfoQueryParam queryParam) {
        PageInfo pageInfo = userInfoService.pageQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }
}

