package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.CarRequest;
import com.online.taxi.service.CarAmountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车辆统计
 *
 * @author dongjb
 * @date 2021/04/20
 */
@RestController
@RequestMapping("/car")
@Slf4j
@RequiredArgsConstructor
public class CarController {

    @NonNull
    private final CarAmountService carAmountService;

    /**
     * 车辆统计接口
     *
     * @param carRequest 车辆统计申请
     * @return ResponseResult实例
     */
    @PostMapping("/car_amount")
    public ResponseResult<?> carAmount(@RequestBody CarRequest carRequest) {
        return carAmountService.carAmount(carRequest);
    }
}
