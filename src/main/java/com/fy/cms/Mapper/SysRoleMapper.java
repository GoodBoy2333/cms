package com.fy.cms.Mapper;
import com.fy.cms.Entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectByUserId(@Param("userId") String userId);

    List<SysRole> findByAll(SysRole sysRole);
}