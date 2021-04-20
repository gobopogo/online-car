package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;

import java.util.Map;

/**
 * 支付宝支付服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface AlipayService {

    /**
     * 预支付
     *
     * @param yid          乘客标识
     * @param capital      本金
     * @param giveFee      赠款
     * @param source       来源
     * @param rechargeType 支付累心
     * @param orderId      订单号
     * @return 结果
     */
    String prePay(Integer yid, Double capital, Double giveFee, String source, Integer rechargeType, Integer orderId);

    /**
     * 支付回调
     *
     * @param params 支付返回数据
     * @return 是否成功
     */
    boolean callback(Map<String, String> params);

    /**
     * 验签
     *
     * @param params 支付返回数据
     * @return 是否成功
     */
    Boolean checkAlipaySign(Map<String, String> params);

    /**
     * 支付查询
     *
     * @param orderId 订单号
     * @param tradeNo 交易号
     * @return ResponseResult实例
     */
    ResponseResult<?> payResult(Integer orderId, String tradeNo);

}
