package com.fy.cms.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    /**
    * 主键
    */
    private BigDecimal id;

    /**
    * 角色名
    */
    private String name;

    /**
    * 描述
    */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String description;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}