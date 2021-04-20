package com.online.taxi.request;

import lombok.Data;

/**
 * 退款申请对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class RefundRequest {

    private Double refundPrice;

    private Integer orderId;

    private Integer yid;

    private String createUser;
}
