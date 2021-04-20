package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.DiscountCouponsRequest;

/**
 * 优惠券统计服务
 *
 * @author dongjb
 * @date 2020/04/20
 */
public interface DiscountCouponsService {

    /**
     * 优惠券统计
     *
     * @param request 优惠券统计申请对象
     * @return ResponseResult实例
     */
    ResponseResult<?> discountCouponsStatistics(DiscountCouponsRequest request);
}
