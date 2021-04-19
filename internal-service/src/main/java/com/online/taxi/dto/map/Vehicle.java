package com.online.taxi.dto.map;

import lombok.Data;

/**
 * 车辆调度车辆信息
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Vehicle {

    private String vehicleId;

    private String longitude;

    private String latitude;

    private String distance;

}
