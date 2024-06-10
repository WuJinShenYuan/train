package org.xjydev.train.common.resp;

import java.io.Serializable;

/**
 * 通用响应类
 *
 * @param <T> 响应数据类型
 */
public class CommonResp<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T data;

    public CommonResp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResp(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResp(Integer code) {
        this(code, null);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public String toString() {
        return "CommonResp(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
