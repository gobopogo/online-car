package com.online.taxi.dto;

import lombok.Data;

/**
 * 订单基本信息
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class BaseInfoDto {
    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 服务名称
     */
    private String serviceTypeName;

    /**
     * 车辆级别名称
     */
    private String carLevelName;
}
