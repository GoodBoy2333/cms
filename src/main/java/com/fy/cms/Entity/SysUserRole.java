package com.fy.cms.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class SysUserRole implements Serializable {
    /**
    * 用户主键
    */
    private BigDecimal userId;

    /**
    * 角色主键
    */
    private BigDecimal roleId;

    private static final long serialVersionUID = 1L;
}