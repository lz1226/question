package com.paper.question.web.controller;

//import com.paper.question.domain.dto.LoginForm;
//import com.paper.question.domain.util.R;
//import com.paper.question.domain.util.ShiroUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//    @PostMapping(value = "/login")
//    @ResponseBody
//    public Object login(@RequestBody LoginForm loginForm){
//        System.out.println("走了信息");
//        try{
//            Subject subject = ShiroUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
//            subject.login(token);
//        }catch (UnknownAccountException e) {
//            return R.fail(e.getMessage());
//        }catch (IncorrectCredentialsException e) {
//            return R.fail("账号或者密码不正确");
//        }catch (LockedAccountException e) {
//            return R.fail("账号已被锁定,请联系管理员");
//        }catch (AuthenticationException e) {
//            return R.fail("账户验证失败");
//        }
//
//        return R.ok(ShiroUtils.getUserEntity());
//    }

}
