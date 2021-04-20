package com.online.taxi.constant;

import com.online.taxi.constatnt.CodeEnum;
import lombok.Getter;

/**
 * 交易类型
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Getter
public enum TradeTypeEnum implements CodeEnum {
    /**
     * 充值
     */
    RECHARGE(1, "充值"),

    /**
     * 消费
     */
    CONSUME(2, "消费"),

    /**
     * 退款
     */
    REFUND(3, "退款"),

    /**
     * 冻结
     */
    FREEZE(4, "冻结"),

    /**
     * 补扣
     */
    REPLENISH(5, "补扣"),

    /**
     * 尾款支付
     */
    TAIL(6, "尾款支付"),

    /**
     * 解冻
     */
    UN_FREEZE(7, "解冻"),

    EX(999, "none");
    private final int code;
    private final String value;

    TradeTypeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}