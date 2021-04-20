package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;

/**
 * 消费服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface ConsumeService {

    /**
     * 冻结
     *
     * @param yid        乘客id
     * @param orderId    订单号
     * @param price      金额
     * @param limitPrice 限制金额
     * @return ResponseResult实例
     */
    ResponseResult<?> freeze(Integer yid, Integer orderId, Double price, Double limitPrice);

    /**
     * 解冻
     *
     * @param yid     乘客id
     * @param orderId 订单号
     * @return ResponseResult实例
     */
    ResponseResult<?> unFreeze(Integer yid, Integer orderId);

    /**
     * 支付
     *
     * @param yid            乘客id
     * @param orderId        订单号
     * @param price          金额
     * @param tailPrice      限制金额
     * @param replenishPrice 补充金额
     * @return ResponseResult实例
     */
    ResponseResult<?> pay(Integer yid, Integer orderId, Double price, Double tailPrice, Double replenishPrice);
}
