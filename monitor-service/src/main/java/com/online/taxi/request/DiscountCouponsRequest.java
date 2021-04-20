package com.online.taxi.request;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 优惠券统计申请对象
 *
 * @author dongjb
 * @date 2020/04/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DiscountCouponsRequest {


    /**
     * 查询周期
     * 1：天、2：月
     */
    private String period;

    /**
     * 开始时间
     */
    private String begin;

    /**
     * 结束时间
     */
    private String end;
}
