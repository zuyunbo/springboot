package com.bobo.springboot.controller;

import com.bobo.springboot.common.BaseResponseUtil;
import com.bobo.springboot.param.RoleInfoQueryParam;
import com.bobo.springboot.service.RoleInfoService;
import com.bobo.springboot.entity.RoleInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/roleInfo")
public class RoleInfoController {

    @Autowired
    RoleInfoService roleInfoService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody RoleInfo entity) {
        int result = roleInfoService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        RoleInfo entity = roleInfoService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody RoleInfo entity) {
        int result = roleInfoService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = roleInfoService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }

    @GetMapping(value = "/list")
    public Object list(RoleInfoQueryParam queryParam) {
        PageInfo pageInfo = roleInfoService.pageQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }
}

