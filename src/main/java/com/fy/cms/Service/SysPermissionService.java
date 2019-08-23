package com.fy.cms.Service;

import com.fy.cms.Entity.SysPermission;

import java.math.BigDecimal;
import java.util.List;

public interface SysPermissionService{


    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectByUserId(String userId);

}
