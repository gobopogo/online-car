package com.online.taxi.response;

import lombok.Data;

/**
 * 支付结果
 *
 * @author dongjb
 * @date 2021/02/20
 */
@Data
public class PayResultResponse {
    private Integer status;

    public PayResultResponse(Integer status) {
        this.status = status;
    }
}
