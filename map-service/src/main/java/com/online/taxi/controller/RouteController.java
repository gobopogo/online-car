package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.Distance;
import com.online.taxi.dto.map.Points;
import com.online.taxi.dto.map.request.RouteRequest;
import com.online.taxi.service.RouteService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 高德路径API
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    @NonNull
    private final RouteService routeService;

    @GetMapping(value = "distance")
    public ResponseResult distance(RouteRequest routeRequest) {

        String vehicleId = routeRequest.getVehicleId();
        String city = routeRequest.getCity();
        Long startTime = routeRequest.getStartTime();
        Long endTime = routeRequest.getEndTime();
        Distance distance = routeService.getRoute(vehicleId, city, startTime, endTime);

        return ResponseResult.success(distance);
    }

    @GetMapping(value = "points")
    public ResponseResult points(RouteRequest routeRequest) {

        String vehicleId = routeRequest.getVehicleId();
        String city = routeRequest.getCity();
        Long startTime = routeRequest.getStartTime();
        Long endTime = routeRequest.getEndTime();
        String correction = routeRequest.getCorrection();
        Points amapPointsResponse;
        if (StringUtils.isNotBlank(correction) && correction.trim().equals("origin")) {
            amapPointsResponse = routeService.getPointsAllPage(vehicleId, city, startTime, endTime, "");
        } else {
            amapPointsResponse = routeService.getPointsAllPage(vehicleId, city, startTime, endTime, "driving");
        }

        return ResponseResult.success(amapPointsResponse);
    }


}
