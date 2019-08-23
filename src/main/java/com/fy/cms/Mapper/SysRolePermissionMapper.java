package com.fy.cms.Mapper;

import com.fy.cms.Entity.SysRolePermission;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleId") BigDecimal roleId, @Param("permissionId") BigDecimal permissionId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}