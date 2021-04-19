package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * 地图距离申请对象
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class DistanceRequest {

    private String originLongitude;

    private String originLatitude;

    private String destinationLongitude;

    private String destinationLatitude;

}
