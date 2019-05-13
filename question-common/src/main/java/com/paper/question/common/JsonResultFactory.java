package com.paper.question.common;

import java.util.HashMap;

public final class JsonResultFactory {
    public JsonResultFactory() {
    }

    public static JsonResult get(ReturnCode returnCode, String error, Object data) {
        JsonResult result = new JsonResult();
        result.setCode(returnCode.getCode());
        result.setDesc(returnCode.getCodeDesc());
        result.setError(error);
        result.setData(data);
        return result;
    }

    public static JsonResult get(ReturnCode returnCode, String error) {
        return get(returnCode, error, new HashMap(0));
    }

    public static JsonResult get(Object data) {
        return get(ReturnCode.SUCCESS, "", data);
    }

    public static JsonResult ok() {
        return get(ReturnCode.SUCCESS, "", new HashMap(0));
    }
}
