package com.fy.cms.Service;

import com.fy.cms.Entity.SysRole;

import java.math.BigDecimal;
import java.util.List;

public interface SysRoleService{


    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectByUserId(String userId);



	List<SysRole> findByAll(SysRole sysRole);


}
