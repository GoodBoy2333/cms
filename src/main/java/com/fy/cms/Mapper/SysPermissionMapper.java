package com.fy.cms.Mapper;

import com.fy.cms.Entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectByUserId(@Param("userId") String userId);
}