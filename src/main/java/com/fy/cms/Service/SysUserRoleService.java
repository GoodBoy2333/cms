package com.fy.cms.Service;

import java.math.BigDecimal;
import com.fy.cms.Entity.SysUserRole;
public interface SysUserRoleService{


    int deleteByPrimaryKey(BigDecimal userId,BigDecimal roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

}
