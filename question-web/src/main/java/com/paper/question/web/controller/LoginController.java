package com.paper.question.web.controller;
import com.paper.question.domain.dto.LoginForm;
import com.paper.question.domain.util.R;
import com.paper.question.domain.util.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    @ResponseBody
    public Object login(ServletResponse response,@RequestBody LoginForm loginForm){
        HttpServletResponse resp = (HttpServletResponse) response;
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
//        resp.addHeader("Access-Control-Allow-Headers", "Token,Content-Type,Authorization,Content-Disposition,Accept,ServerTime,x_requested_with");
//        resp.addHeader("Access-Control-Expose-Headers", "Token,Content-Type,Authorization,Content-Disposition,Accept,ServerTime");
        System.out.println("走了信息");
        try{
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
            subject.login(token);
        }catch (UnknownAccountException e) {
            return R.fail(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return R.fail("账号或者密码不正确");
        }catch (LockedAccountException e) {
            return R.fail("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return R.fail("账户验证失败");
        }

        return R.ok(ShiroUtils.getUserEntity());
    }

}
