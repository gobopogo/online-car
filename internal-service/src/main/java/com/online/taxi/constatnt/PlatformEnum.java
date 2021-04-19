package com.online.taxi.constatnt;

import lombok.Getter;

/**
 * 平台类型
 *
 * @author : dongjb
 * @date 2021/04/19
 */
@Getter
public enum PlatformEnum {
    /**
     * iOS系统
     */
    IOS(1, "iOS"),
    /**
     * Android系统
     */
    ANDROID(2, "Android"),
    /**
     * 其他系统
     */
    OTHER(9, "其他系统");

    private final int code;
    private final String value;

    PlatformEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
