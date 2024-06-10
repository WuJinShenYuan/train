package org.xjydev.train.common.exception;

/**
 * 业务异常枚举
 */
public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXIST("手机号已注册");

    private String message;

    BusinessExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "message='" + message + '\'' +
                '}' + super.toString();
    }
}
