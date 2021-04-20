package com.online.taxi.response;

import lombok.Data;

/**
 * 微信支付结果
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class WeixinPayResponse {
    private String appId;
    private long timeStamp;
    private String nonceStr;
    private String packageData;
    private String prepayId;
    private String partnerId;
    private String signType;
    private String paySign;
    private String outTradeNo;
}
