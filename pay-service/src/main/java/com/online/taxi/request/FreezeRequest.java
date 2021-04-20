package com.online.taxi.request;

import lombok.Data;

/**
 * 冻结申请对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class FreezeRequest {

    /**
     * 冻结解冻金额
     */
    private Double price;

    private Integer orderId;

    private Integer yid;

    private Double limitPrice;
}
