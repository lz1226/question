package com.paper.question.common.exception;


import com.paper.question.common.ReturnCode;
import com.paper.question.common.base.SystemException;

public class FileStorageException extends SystemException {

    @Override
    public ReturnCode getReturnCode() {
        return ReturnCode.ERR_UPLOAD;
    }

    public FileStorageException() {
        super();
    }

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStorageException(Throwable cause) {
        super(cause);
    }

    protected FileStorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
