package com.fy.cms.Mapper;

import com.fy.cms.Entity.SysUserRole;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") BigDecimal userId, @Param("roleId") BigDecimal roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}