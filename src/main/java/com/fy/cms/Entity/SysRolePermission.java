package com.fy.cms.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class SysRolePermission implements Serializable {
    /**
    * 角色主键
    */
    private BigDecimal roleId;

    /**
    * 权限主键
    */
    private BigDecimal permissionId;

    private static final long serialVersionUID = 1L;
}