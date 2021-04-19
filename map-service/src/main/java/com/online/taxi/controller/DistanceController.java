package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.DistanceRequest;
import com.online.taxi.service.DistanceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地图距离api
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequiredArgsConstructor
public class DistanceController {

    @NonNull
    private final DistanceService distanceService;

    @GetMapping(value = "/distance")
    public ResponseResult distance(DistanceRequest distanceRequest) {
        return distanceService.distance(distanceRequest);
    }
}
