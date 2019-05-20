package com.paper.question.common.exception;


import com.paper.question.common.ReturnCode;
import com.paper.question.common.base.SystemException;

public class FileMissingExtNameException extends SystemException {

    @Override
    public ReturnCode getReturnCode() {
        return ReturnCode.MISSING_FILE_EXT_NAME;
    }

    public FileMissingExtNameException() {
        super();
    }

    public FileMissingExtNameException(String message) {
        super(message);
    }

    public FileMissingExtNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileMissingExtNameException(Throwable cause) {
        super(cause);
    }

    protected FileMissingExtNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
