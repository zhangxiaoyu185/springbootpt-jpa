package com.xiaoyu.lingdian.util;

public class StringUtil {

    /**
     * 字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
