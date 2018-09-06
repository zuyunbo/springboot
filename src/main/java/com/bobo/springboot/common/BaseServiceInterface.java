package com.bobo.springboot.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 公共接口类
 */
public interface BaseServiceInterface<T, Q, Z> {

    /**
     * 新增
     *
     * @param entity 新增实体
     * @return 操作行数
     */
    int save(T entity);

    /**
     * 修改
     *
     * @param entity 修改实体
     * @return 操作行数
     */
    int update(T entity);

    /**
     * 删除
     *
     * @param id 主键
     * @return 操作行数
     */
    int remove(Z id);

    /**
     * 主键查询
     *
     * @param id 主键
     * @return 查询结果
     */
    T getById(Z id);

    /**
     * 查询分页集合
     *
     * @param queryParam 查询条件封装实体
     * @return 查询结果
     */
    PageInfo<T> pageQuery(Q queryParam);

    /**
     * 查询集合
     *
     * @param queryParam 查询条件封装实体
     * @return 查询结果
     */
    List<T> listQuery(Q queryParam);

}
