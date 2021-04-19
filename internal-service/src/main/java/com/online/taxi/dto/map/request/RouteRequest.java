package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * 高德路径请求
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class RouteRequest {

    private String vehicleId;

    private String city;

    private Long startTime;

    private Long endTime;

    private String correction;

}
