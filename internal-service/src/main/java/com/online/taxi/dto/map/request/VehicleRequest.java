package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * 车辆请求
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class VehicleRequest {

    private String vehicleId;

    private String city;

    private String longitude;

    private String latitude;

    private Double accuracy;

    private Double direction;

    private Double speed;

    private Double height;

    private String locationType;

    private Integer state;

    private Integer vehicleType;

    private Integer seats;

    private Integer battery;

    private Integer mileage;

    private String orderId;

    private Long timestamp;

}
