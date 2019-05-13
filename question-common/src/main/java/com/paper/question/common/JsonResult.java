package com.paper.question.common;

import java.io.Serializable;

public class JsonResult implements Serializable {
    private String code;
    private String desc;
    private String error;
    private Object data;

    public JsonResult() {
    }

    public String toString() {
        return "JsonResult{code='" + this.code + '\'' + ", desc='" + this.desc + '\'' + ", error='" + this.error + '\'' + ", data=" + this.data + '}';
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

