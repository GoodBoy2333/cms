package com.fy.cms.ServiceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import com.fy.cms.Mapper.SysRolePermissionMapper;
import com.fy.cms.Entity.SysRolePermission;
import com.fy.cms.Service.SysRolePermissionService;
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService{

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(BigDecimal roleId,BigDecimal permissionId) {
        return sysRolePermissionMapper.deleteByPrimaryKey(roleId,permissionId);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

}
