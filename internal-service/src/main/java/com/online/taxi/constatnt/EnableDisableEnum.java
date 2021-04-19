package com.online.taxi.constatnt;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否启用
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Getter
@AllArgsConstructor
public enum EnableDisableEnum implements CodeEnum {

    /**
     * 未启用
     */
    ENABLE(0, "未启用"),
    /**
     * 启用
     */
    DISABLE(1, "启用");
    private final int code;
    private final String value;
}
