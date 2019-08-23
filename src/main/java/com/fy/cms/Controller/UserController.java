package com.fy.cms.Controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Snowflake;
import com.fy.cms.ApiCommon.ApiResponse;
import com.fy.cms.Entity.SysUser;
import com.fy.cms.Service.SysUserService;
import com.fy.cms.Util.Jwt.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈用户访问控制类〉
 *
 * @author fangyan
 * @create 2019/8/21
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    Snowflake snowflake;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    String tokenHead;

    @PostMapping("/login")
    public ApiResponse login(@RequestParam String username, @RequestParam String password) {
        String token = null;
        SysUser userDetails= new SysUser();
        //密码需要客户端加密后传递
        try {
//            也可以使用passwordEncoder.matches匹配密码
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            BeanUtil.copyProperties(authentication.getPrincipal(),userDetails);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        if (token == null) {
            throw new BadCredentialsException("用户名或密码不正确");
        }
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("user", userDetails);
        return ApiResponse.success(tokenMap);
    }

    @PostMapping
    public ApiResponse register(SysUser sysUser) {
        SysUser sysUserByDataBase = sysUserService.findOneByUserNameOrEmailAndPassword(sysUser.getUsername(), sysUser.getEmail(), "");
        if (sysUserByDataBase != null) {
            return ApiResponse.fail("用户名重复");
        }
        if (StringUtils.isEmpty(sysUser.getUsername())) {
            return ApiResponse.fail("用户名为空");
        }
        if (StringUtils.isEmpty(sysUser.getPassword())) {
            return ApiResponse.fail("密码为空");
        }
        sysUser.setId(BigDecimal.valueOf(snowflake.nextId()));
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(encodePassword);
        sysUser.setStatus("1");
        sysUser.setCreateTime(new Date());
        sysUserService.insert(sysUser);
        return ApiResponse.success("注册成功");
    }

    @GetMapping("/check/{usernameoremail}")
    public ApiResponse repeat(@PathVariable("usernameoremail")String usernameoremail) {
        SysUser sysUserByDataBase = sysUserService.findOneByUserNameOrEmailAndPassword(usernameoremail, usernameoremail, "");
        if (sysUserByDataBase != null) {
            return ApiResponse.fail("已注册");
        }
        return ApiResponse.success("未注册");
    }
}
