package org.xjydev.train.common.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getBusinessExceptionEnum() {
        return e;
    }

    public void setBusinessExceptionEnum(BusinessExceptionEnum e) {
        this.e = e;
    }

    /**
     * 不写入堆栈信息（日志），提高性能
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
