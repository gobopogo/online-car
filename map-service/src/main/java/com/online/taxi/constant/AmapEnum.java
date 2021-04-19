package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;

/**
 * 高德接口请求状态
 *
 * @author dongjb
 * @date 2021/04/15
 */
public enum AmapEnum implements CodeEnum {

    /**
     * 高德接口请求成功
     */
    OK(0, "amap sccess"),

    /**
     * 高德接口请求失败
     */
    FAIL(1, "amap fail"),

    /**
     * 高德接口请求异常
     */
    EXCEPTION(2, "amap exception");

    private final int code;
    private final String value;

    AmapEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public int getCode() {
        return code;
    }
}
