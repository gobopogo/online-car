package com.online.taxi.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单其他费用
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
public class OrderOtherPrice {
    private Integer orderId;
    private Integer passengerId;
    private BigDecimal totalPrice;
}
