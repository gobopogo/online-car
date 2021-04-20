package com.online.taxi.request;

import lombok.Data;

/**
 * 扣款申请
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class ConsumeRequest {

    /**
     * 正常扣款金额
     */
    private Double price;

    /**
     * 尾款金额
     */
    private Double tailPrice;

    /**
     * 补扣宽金额
     */
    private Double replenishPrice;

    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 乘客标识
     */
    private Integer yid;
}
