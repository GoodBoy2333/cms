package com.fy.cms.Service;
import com.fy.cms.Entity.SysUser;

import java.math.BigDecimal;
public interface SysUserService{


    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);



	SysUser findOneByUserNameOrEmailAndPassword(String userName,String email,String password);


}
