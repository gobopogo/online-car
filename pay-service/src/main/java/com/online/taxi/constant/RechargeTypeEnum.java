package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;
import lombok.Getter;

/**
 * 充值模式
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Getter
public enum RechargeTypeEnum implements CodeEnum {
    /**
     * 仅充值
     */
    CHARGE(1, "仅充值"),
    /**
     * 充值消费
     */
    CONSUME(2, "充值消费"),

    EX(999, "none");
    private final int code;
    private final String value;

    RechargeTypeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}