package org.xjydev.train.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xjydev.train.common.exception.BusinessException;
import org.xjydev.train.common.resp.CommonResp;
import org.xjydev.train.common.util.ReturnUtil;

/**
 * 统一异常处理，数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     *
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResp<String> exceptionHandler(Exception e) {
        logger.error("系统异常", e);
        return ReturnUtil.error("系统出现异常，请联系管理员");
    }

    /**
     * 业务异常统一处理
     *
     * @param e 业务异常
     * @return 异常信息
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResp<String> businessExceptionHandler(BusinessException e) {
        logger.error("业务异常：{}", e.getBusinessExceptionEnum().getMessage());
        return ReturnUtil.error(e.getBusinessExceptionEnum().getMessage());
    }
}
