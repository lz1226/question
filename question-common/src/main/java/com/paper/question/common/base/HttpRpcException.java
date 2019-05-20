package com.paper.question.common.base;

import com.paper.question.common.ReturnCode;

/**
 * 调用远程http服务异常
 */
public class HttpRpcException extends SystemException {

    @Override
    public ReturnCode getReturnCode() {
        return ReturnCode.REMOTING;
    }

    public HttpRpcException() {
        super();
    }

    public HttpRpcException(String message) {
        super(message);
    }

    public HttpRpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpRpcException(Throwable cause) {
        super(cause);
    }

    protected HttpRpcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
