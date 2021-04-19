package com.online.taxi.constatnt;

import lombok.Getter;

/**
 * 业务接口状态
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Getter
public enum BusinessInterfaceStatus implements CodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(0, "success"),

    /**
     * 操作失败
     */
    FAIL(1, "fail");

    private final int code;
    private final String value;

    BusinessInterfaceStatus(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
