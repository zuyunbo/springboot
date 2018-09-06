package com.bobo.springboot.common;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 公共实体类    这里的id注意要在数据库声明自增长
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4188086172919649925L;

    @Id
    @Column(insertable = false, updatable = false)   // 在插入数据库和修改数据库时 id字段不做操作
    @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库在插入数据时,数据库会自动给主键赋值 无需我们管理
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

