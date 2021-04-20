package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;
import lombok.Getter;

/**
 * 余额变更方向
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Getter
public enum ChangeStatusEnum implements CodeEnum {
    /**
     * 加
     */
    ADD(1, "加"),
    /**
     * 减
     */
    SUB(-1, "减"),

    EX(999, "none");
    private final int code;
    private final String value;

    ChangeStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}