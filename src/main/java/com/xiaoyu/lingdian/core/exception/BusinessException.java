package com.xiaoyu.lingdian.core.exception;

import com.xiaoyu.lingdian.enums.BusinessExceptionEnum;

public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getMsg());
        this.code = businessExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
