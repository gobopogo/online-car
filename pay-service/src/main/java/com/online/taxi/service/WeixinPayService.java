package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.PayResultRequest;
import com.online.taxi.response.WeixinPayResponse;

/**
 * 微信支付服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface WeixinPayService {

    /**
     * 预支付
     *
     * @param yid          乘客标识
     * @param capital      本金
     * @param giveFee      增加
     * @param source       来源
     * @param rechargeType 充值类型
     * @param orderId      订单号
     * @return 微信支付结果
     */
    WeixinPayResponse prePay(Integer yid, Double capital, Double giveFee, String source, Integer rechargeType, Integer orderId);

    /**
     * 回调
     *
     * @param reqXml 支付结果
     * @return 是否成功
     */
    Boolean callback(String reqXml);

    /**
     * 支付查询
     *
     * @param payResultRequest 支付结果请求
     * @return ResponseResult实例
     */
    ResponseResult<?> payResult(PayResultRequest payResultRequest);
}
