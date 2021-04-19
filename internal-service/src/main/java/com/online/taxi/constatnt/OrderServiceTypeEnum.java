package com.online.taxi.constatnt;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单服务类型
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Getter
@AllArgsConstructor
public enum OrderServiceTypeEnum implements CodeEnum {

    /**
     * 实时订单
     */
    REAL_TIME(1, "实时订单"),

    /**
     * 预约订单
     */
    MAKE_AN_APPOINTMENT(2, "预约订单"),

    /**
     * 接机
     */
    PICK_UP(3, "接机"),

    /**
     * 送机
     */
    SEND_MACHINE(4, "送机"),

    /**
     * 半日租
     */
    CHARTERED_CAR(5, "半日租"),

    /**
     * 全日租
     */
    THROUGHOUT_THE_DAY(6, "全日租");

    private final int code;
    private final String value;
}
