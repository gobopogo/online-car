package com.online.taxi.dto;

import lombok.Data;

/**
 * 退款金额对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class RefundPrice {
    Double refundCapital;
    Double refundGiveFee;

    public RefundPrice(Double refundCapital, Double refundGiveFee) {
        this.refundCapital = refundCapital;
        this.refundGiveFee = refundGiveFee;
    }
}
