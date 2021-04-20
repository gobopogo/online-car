package com.online.taxi.response;

import lombok.Data;

/**
 * 车辆统计结果
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Data
public class CarAmountResponse {
    /**
     * 日期
     */
    private String day;

    /**
     * 类型
     */
    private String type;

    /**
     * 总数
     */
    private int count;
}
