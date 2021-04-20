package com.online.taxi.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单统计结果
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Data
public class OrderStatisticsResponse {
    /**
     * 日期
     */
    private String day;

    /**
     * 其它类
     */
    private String serviceType;

    /**
     * 订单总数
     */
    private int orderCount;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
}
