package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.VehicleRequest;
import com.online.taxi.service.VehicleService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 地图车辆api
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class VehicleController {

    @NonNull
    private final VehicleService vehicleService;

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult vehicle(@RequestBody VehicleRequest vehicleRequest) {

        vehicleService.uploadCar(vehicleRequest);
        return ResponseResult.success(null);
    }
}
