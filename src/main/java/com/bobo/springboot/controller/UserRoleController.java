package com.bobo.springboot.controller;

import com.bobo.springboot.common.BaseResponseUtil;
import com.bobo.springboot.param.UserRoleQueryParam;
import com.bobo.springboot.service.UserRoleService;
import com.bobo.springboot.entity.UserRole;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/userRole")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody UserRole entity) {
        int result = userRoleService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        UserRole entity = userRoleService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody UserRole entity) {
        int result = userRoleService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = userRoleService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }

    @GetMapping(value = "/list")
    public Object list(UserRoleQueryParam queryParam) {
        PageInfo pageInfo = userRoleService.pageQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }
}

