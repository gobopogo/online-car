package com.online.taxi.service;

/**
 * 公共支付服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface CommonPayService {

    /**
     * 创建支付描述
     * @param capital 本金
     * @param giveFee 赠额
     * @param prefix 公共描述
     * @return 支付描述
     */
    String createDescription(Double capital, Double giveFee, String prefix);
}
