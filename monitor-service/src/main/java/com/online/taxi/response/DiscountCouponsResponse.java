package com.online.taxi.response;

import lombok.Data;

/**
 * 优惠券统计结果
 *
 * @author dongjb
 * @date 2020/04/20
 */
@Data
public class DiscountCouponsResponse {

    /**
     * 日期
     */
    private String day;

    /**
     * 类型
     */
    private String type;

    /**
     * 结果
     */
    private int count;
}
