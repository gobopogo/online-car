package com.online.taxi.response;

import lombok.Data;

/**
 * 用户统计结果
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Data
public class UserResponse {

    /**
     * 日期
     */
    private String day;

    /**
     * 数量
     */
    private int count;

    /**
     * 手机系统1：ios 2：Android
     */
    private String type;

    /**
     * 1:实时订单 2：预约订单
     */
    private String serviceType;
}
