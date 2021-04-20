package com.online.taxi.request;

import lombok.Data;

/**
 * 支付申请对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PayRequest {

    private Integer yid;
    private Double capital;
    private Double giveFee;
    private String source;
    private Integer rechargeType;
    private Integer orderId;
    private String createUser;

}
