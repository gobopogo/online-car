package com.online.taxi.dto.valuation.discount;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 动态调价
 *
 * @author dongjb
 * @date 2021/04/18
 */
@Data
public class DiscountPrice {

    private BigDecimal discountMaxPrice;
    private Double discount;
}
