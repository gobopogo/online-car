package com.online.taxi.dto.valuation.charging;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 远途服务费
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
public class BeyondRule {

    /**
     * 远途起算公里（公里）
     */
    private Double startKilo;

    /**
     * 远途单价（元/公里）
     */
    private BigDecimal perKiloPrice;
}
