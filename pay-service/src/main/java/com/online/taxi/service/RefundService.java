package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;

/**
 * 退款服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface RefundService {

    /**
     * 退款
     *
     * @param yid         乘客标识
     * @param orderId     订单号
     * @param refundPrice 退款金额
     * @param createUser  创建人
     * @return ResponseResult实例
     */
    ResponseResult<?> refund(Integer yid, Integer orderId, Double refundPrice, String createUser);
}
