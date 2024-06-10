package org.xjydev.train.common.util;

import org.xjydev.train.common.resp.CommonResp;

/**
 * 返回工具类
 */
public class ReturnUtil {

    /**
     * 成功返回
     *
     * @param message 返回信息
     * @param data    返回数据
     * @return 返回对象
     */
    public static <T> CommonResp<T> success(String message, T data) {
        return new CommonResp<>(Constants.SUCCESS_CODE, message, data);
    }

    /**
     * 错误返回
     *
     * @param message 返回信息
     * @return 返回对象
     */
    public static <T> CommonResp<T> error(String message) {
        return new CommonResp<>(Constants.ERROR_CODE, message, null);
    }
}
