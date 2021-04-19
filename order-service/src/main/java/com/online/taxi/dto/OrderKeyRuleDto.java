package com.online.taxi.dto;

import lombok.Data;

/**
 * 订单规则主键
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
public class OrderKeyRuleDto {
    private Integer orderId;
    private Integer cityCode;
    private Integer serviceTypeId;
    private Integer channelId;
    private Integer carTypeId;
}
