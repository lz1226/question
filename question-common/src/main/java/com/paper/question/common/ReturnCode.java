package com.paper.question.common;

public enum ReturnCode {
    SUCCESS("2000", "成功"),
    UNKNOWN("5000", "服务器未知错误"),
    REMOTING("5001", "客户端调用服务端异常"),
    DATA_ACCESS("5002", "服务端数据访问层异常"),
    JSON_ERROR("5003", "JSON序列化/反序列化异常"),
    SYSTEM_ERROR("5004", "系统运行时错误"),
    ERR_UPLOAD("5005", "文件上传出错"),
    MISSING_FILE_EXT_NAME("5006", "缺少文件扩展名"),
    FILE_NUMBER_BEYOND_LIMIT("5007", "文件数量超过限制"),
    USER_EXIST("4001", "用户已存在"),
    USER_NOT_EXIST("4002", "用户不存在"),
    ERR_USER_OR_PASSWORD("4003", "用户或密码错误"),
    ENTITY_NOT_EXIST("4006", "实体不存在"),
    ERR_STATUS("4007", "状态错误"),
    ;

    String code;
    String codeDesc;

    private ReturnCode(String code, String codeDesc) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public String getCode() {
        return this.code;
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }
}
