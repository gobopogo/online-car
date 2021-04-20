package com.online.taxi.service;

import com.online.taxi.entity.ScanPayResData;

import java.util.Map;

/**
 * 第三方支付结果入库
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface ThirdPayService {

    /**
     * 支付宝支付结果入库
     * @param params 支付结果
     */
    void insertAlipay(Map<String, String> params);

    /**
     * 微信支付结果入库
     * @param scanPayResData 支付结果
     */
    void insertWeixinpay(ScanPayResData scanPayResData);
}
