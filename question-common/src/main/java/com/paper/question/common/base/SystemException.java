package com.paper.question.common.base;

import com.paper.question.common.ReturnCode;

/**
 * 系统运行时异常 - 工具类
 */
public class SystemException extends RuntimeException {


    public ReturnCode getReturnCode() {
        return ReturnCode.SYSTEM_ERROR;
    }

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
