package com.fy.cms.ServiceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import com.fy.cms.Entity.SysUserRole;
import com.fy.cms.Mapper.SysUserRoleMapper;
import com.fy.cms.Service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(BigDecimal userId,BigDecimal roleId) {
        return sysUserRoleMapper.deleteByPrimaryKey(userId,roleId);
    }

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return sysUserRoleMapper.insertSelective(record);
    }

}
