package org.xjydev.train.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * @throws Exception 异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResp<String> exceptionHandler(Exception e) throws Exception {
        logger.error("系统异常", e);
        return ReturnUtil.error(e.getMessage());
    }
}
