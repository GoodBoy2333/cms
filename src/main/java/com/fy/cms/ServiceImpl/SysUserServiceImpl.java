package com.fy.cms.ServiceImpl;
import com.fy.cms.Entity.SysUser;
import com.fy.cms.Mapper.SysUserMapper;
import com.fy.cms.Service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
@Service
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(BigDecimal id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(BigDecimal id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

	@Override
	public SysUser findOneByUserNameOrEmailAndPassword(String userName,String email,String password){
		 return sysUserMapper.findOneByUserNameOrEmailAndPassword(userName,email,password);
	}




}
