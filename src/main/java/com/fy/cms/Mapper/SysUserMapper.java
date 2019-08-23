package com.fy.cms.Mapper;
import org.apache.ibatis.annotations.Param;
import com.fy.cms.Entity.SysUser;

import java.math.BigDecimal;

public interface SysUserMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findOneByUserNameOrEmailAndPassword(@Param("userName")String userName,@Param("email")String email,@Param("password")String password);
}