package com.online.taxi.request;

import lombok.Data;

/**
 * 支付结果请求
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PayResultRequest {

    private String outTradeNo;

    private Integer orderId;

}
