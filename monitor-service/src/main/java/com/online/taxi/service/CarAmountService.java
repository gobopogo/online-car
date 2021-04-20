package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.CarRequest;

/**
 * 车辆统计
 *
 * @author dongjb
 * @date 2021/04/20
 */

public interface CarAmountService {

    /**
     * 车辆统计
     *
     * @param request 车辆统计申请对象
     * @return ResponseResult实例
     */
    ResponseResult<?> carAmount(CarRequest request);
}
