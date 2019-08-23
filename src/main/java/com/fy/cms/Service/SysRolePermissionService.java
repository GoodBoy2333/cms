package com.fy.cms.Service;

import java.math.BigDecimal;
import com.fy.cms.Entity.SysRolePermission;
public interface SysRolePermissionService{


    int deleteByPrimaryKey(BigDecimal roleId,BigDecimal permissionId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

}
