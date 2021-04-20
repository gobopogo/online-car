package com.online.taxi.service.impl;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.mapper.CarAmountMapper;
import com.online.taxi.request.CarRequest;
import com.online.taxi.response.CarAmountResponse;
import com.online.taxi.service.CarAmountService;
import com.online.taxi.util.GetBetweenDates;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CarAmountServiceImpl implements CarAmountService {

    @NonNull
    private final CarAmountMapper carAmountMapper;

    /**
     * 车辆统计
     *
     * @param request 车辆统计申请对象
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult<?> carAmount(CarRequest request) {
        List<CarAmountResponse> carAmountResponses;
        Map<String, Object> param = new HashMap<>(3);
        param.put("period", request.getPeriod());
        param.put("begin", request.getBegin());
        param.put("end", request.getEnd());
        List<String> list;
        if (request.getPeriod().equals("1")) {
            list = GetBetweenDates.getBetweenDate(request.getBegin(), request.getEnd());
        } else {
            list = GetBetweenDates.getMonthBetweenDate(request.getBegin(), request.getEnd());
        }
        param.put("list", list);
        carAmountResponses = carAmountMapper.carAmount(param);
        return ResponseResult.success(carAmountResponses);
    }
}
