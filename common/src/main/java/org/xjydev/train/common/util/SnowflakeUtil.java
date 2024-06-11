package org.xjydev.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * 雪花算法工具类
 */
public class SnowflakeUtil {

    private static long workerId = 1;   // 工作机器ID(0~31)
    private static long datacenterId = 1;   // 数据中心ID(0~31)

    /**
     * 获取下一个ID（基于雪花算法）
     *
     * @return 下一个ID
     */
    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextId();
    }

    /**
     * 获取下一个ID字符串（基于雪花算法）
     *
     * @return 下一个ID字符串
     */
    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextIdStr();
    }
}
