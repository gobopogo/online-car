package com.online.taxi.dto;

import lombok.Data;

/**
 * 订单批价结果
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
public class OrderPrice {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单价格
     */
    private Double price;
}
