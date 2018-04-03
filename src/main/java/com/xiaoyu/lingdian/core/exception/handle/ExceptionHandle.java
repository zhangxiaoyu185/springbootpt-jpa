package com.xiaoyu.lingdian.core.exception.handle;

import com.xiaoyu.lingdian.core.exception.BusinessException;
import com.xiaoyu.lingdian.enums.BusinessExceptionEnum;
import com.xiaoyu.lingdian.response.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespModel handle(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return new RespModel(businessException.getCode(), businessException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return new RespModel(BusinessExceptionEnum.UNKONW_ERROR.getCode(), BusinessExceptionEnum.UNKONW_ERROR.getMsg());
        }
    }
}
