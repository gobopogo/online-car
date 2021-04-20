package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;
import lombok.Getter;

/**
 * 冻结状态
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Getter
public enum FreezeStatusEnum implements CodeEnum {
    /**
     * 冻结
     */
    FREEZE(1, "冻结"),
    /**
     * 解冻
     */
    UNFREEZE(0, "解冻"),

    EX(999, "none");
    private final int code;
    private final String value;

    FreezeStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}