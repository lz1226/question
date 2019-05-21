package com.paper.question.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.dto.LoginDto;

/**
 * 
 * @description: 这里用一句话描述这个方法的作用 TODO
 * @author 郑晓龙
 * @update 2019年5月20日 下午2:47:32
 */
@RestController
public class LoginController {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public LoginController(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public JsonResult notLogin() {
    	return JsonResultFactory.get("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public JsonResult notRole() {
    	return JsonResultFactory.get("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public JsonResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JsonResultFactory.get("成功注销！");
    }

    /**
     * 登陆
     *
     * @param loginDto 用户名
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody LoginDto loginDto) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getName(), loginDto.getPassword());
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = sysUserMapper.getRole(loginDto.getName()).getName();
        if ("user".equals(role)) {
            return JsonResultFactory.get("欢迎登陆");
        }
        if ("admin".equals(role)) {
            return JsonResultFactory.get("欢迎来到管理员页面");
        }
        return JsonResultFactory.get("权限错误！");
    }
}
