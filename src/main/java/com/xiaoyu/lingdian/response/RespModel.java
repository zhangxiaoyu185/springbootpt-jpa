package com.xiaoyu.lingdian.response;

import com.xiaoyu.lingdian.util.StringUtil;

/**
 * 公共model封装
 *
 * @author zhangyu
 * @since 2018-01-20
 */
public class RespModel {

    public enum RespCode {

        SUCCESS(0, "操作成功"),
        SYS_EXCEPTION(-1, "系统异常"),
        NO_PRIVILEGE(-2, "没有权限"),
        PARAM_EXCEPTION(-3, "参数异常"),
        SESSION_OUT_TIME(-4, "会话超时");

        private final int code;

        private final String desc;

        RespCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 响应码
     */
    private int code = RespCode.SUCCESS.getCode();

    /**
     * 响应码描述
     */
    private String desc = RespCode.SUCCESS.getDesc();

    /**
     * 具体数据
     */
    private Object rows;

    public RespModel() {
    }

    public RespModel(Object rows) {
        this.rows = rows;
    }

    public RespModel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public RespModel(int code, String desc, Object rows) {
        this.code = code;
        this.desc = desc;
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public static RespModel success(String msg) {
        msg = StringUtil.isEmpty(msg) ? RespCode.SUCCESS.getDesc() : msg;
        return new RespModel(RespCode.SUCCESS.getCode(), msg);
    }

    public static RespModel success(String msg, Object rows) {
        msg = StringUtil.isEmpty(msg) ? RespCode.SUCCESS.getDesc() : msg;
        return new RespModel(RespCode.SUCCESS.getCode(), msg, rows);
    }

    public static RespModel failure(String msg) {
        msg = StringUtil.isEmpty(msg) ? RespCode.SYS_EXCEPTION.getDesc() : msg;
        return new RespModel(RespCode.SYS_EXCEPTION.getCode(), msg);
    }

    public static RespModel noPrivilege(String msg) {
        msg = StringUtil.isEmpty(msg) ? RespCode.NO_PRIVILEGE.getDesc() : msg;
        return new RespModel(RespCode.NO_PRIVILEGE.getCode(), msg);
    }

    public static RespModel paramException(String msg) {
        msg = StringUtil.isEmpty(msg) ? RespCode.PARAM_EXCEPTION.getDesc() : msg;
        return new RespModel(RespCode.PARAM_EXCEPTION.getCode(), msg);
    }

    public static RespModel outTimeException(String msg) {
        msg = StringUtil.isEmpty(msg) ? RespCode.SESSION_OUT_TIME.getDesc() : msg;
        return new RespModel(RespCode.SESSION_OUT_TIME.getCode(), msg);
    }

}
