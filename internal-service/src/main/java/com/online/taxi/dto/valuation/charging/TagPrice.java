package com.online.taxi.dto.valuation.charging;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 标签费用
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
public class TagPrice {
    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签费用
     */
    private BigDecimal price;
}
