package com.paper.question.web.controller;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.common.ReturnCode;

/**
 * 
 * @description: 异常处理controller
 * @author 郑晓龙
 * @update 2019年5月20日 下午2:47:41
 */
@RestControllerAdvice
public class ExceptionController {
    

    /**
     * 捕捉 CustomRealm 抛出的异常
     */
	
    @ExceptionHandler(AccountException.class)
    public JsonResult handleShiroException(Exception ex) {
    	return JsonResultFactory.get(ReturnCode.UNKNOWN,ex.getMessage());
    }
    
    /**
     * 
     * @description: 没有权限
     * @param ex
     * @return
     * @author 郑晓龙
     * @update 2019年5月21日 上午11:12:53
     */
    @ExceptionHandler(UnauthorizedException.class)
    public JsonResult handleShiroExceptions(Exception ex) {
        return JsonResultFactory.get(ReturnCode.UNKNOWN,"无权限");
    }
    
    /**
     * 权限认证失败
     */
    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        return "权限认证失败";
    }

    
}
