package com.fy.cms.Controller;

import com.fy.cms.ApiCommon.ApiResponse;
import com.fy.cms.Entity.SysRole;
import com.fy.cms.Service.SysRoleService;
import com.fy.cms.ServiceImpl.SysRoleServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author fangyan
 * @create 2019/8/22
 * @since 1.0.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysRoleServiceImpl sysRoleServiceImpl;

    @GetMapping
    public ApiResponse<PageInfo<SysRole>> findByAll(@RequestParam(required = false, defaultValue = "1") int page,
                                                    @RequestParam(required = false, defaultValue = "10") int pageSize, SysRole sysRole) {
        return ApiResponse.success(sysRoleServiceImpl.findByAllwithPage(page, pageSize, sysRole));
    }
}
