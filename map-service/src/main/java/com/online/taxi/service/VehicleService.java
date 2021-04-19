package com.online.taxi.service;

import com.online.taxi.dto.map.request.VehicleRequest;

/**
 * 地图车辆服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface VehicleService {

    /**
     * 同步车辆
     *
     * @param vehicleRequest
     * @return
     */
    public String uploadCar(VehicleRequest vehicleRequest);
}
