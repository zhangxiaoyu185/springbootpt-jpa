package com.xiaoyu.lingdian.enums;

public enum BusinessExceptionEnum {

    SYS_EXCEPTION(-1, "系统异常"),
    NO_PRIVILEGE(-2, "没有权限"),
    PARAM_EXCEPTION(-3, "参数异常"),
    SESSION_OUT_TIME(-4, "会话超时"),
    UNKONW_ERROR(-5, "未知错误"),
    RANK_DEFICIENT(-6, "等级不够"),
    NO_DATA(-7, "数据不存在");

    private Integer code;

    private String msg;

    BusinessExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
