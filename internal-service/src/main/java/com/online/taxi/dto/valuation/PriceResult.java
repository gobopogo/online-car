package com.online.taxi.dto.valuation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 计价结果DTO
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResult {
    private Double price;
}
