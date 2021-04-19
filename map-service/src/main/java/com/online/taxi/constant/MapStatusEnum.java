package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;

/**
 * 地图常量
 *
 * @author dongjb
 * @date 2021/04/15
 */
public enum MapStatusEnum implements CodeEnum {

    /**
     * 围栏已存在
     */
    FENCE_ALREAD(106, "新增围栏已存在"),


    EX(999, "none");
    private final int code;
    private final String value;

    MapStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public int getCode() {
        return code;
    }
}
