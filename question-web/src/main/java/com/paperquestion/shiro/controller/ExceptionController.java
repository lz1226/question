package com.paperquestion.shiro.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.common.ReturnCode;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
