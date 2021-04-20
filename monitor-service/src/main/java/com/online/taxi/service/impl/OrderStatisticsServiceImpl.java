package com.online.taxi.service.impl;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.mapper.OrderStatisticsMapper;
import com.online.taxi.request.OrderRequest;
import com.online.taxi.response.OrderStatisticsResponse;
import com.online.taxi.service.OrderStatisticsService;
import com.online.taxi.util.GetBetweenDates;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单统计服务
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderStatisticsServiceImpl implements OrderStatisticsService {

    @NonNull
    private final OrderStatisticsMapper orderStatisticsMapper;

    /**
     * 订单统计
     *
     * @param request 订单统计申请对象
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult<?> orderStatistics(OrderRequest request) {
        //查看类目：1：订单统计
        String statistics = "1";
        //统计周期-天
        String periodDay = "1";
        List<OrderStatisticsResponse> orderStatisticsResponse;
        Map<String, Object> param = new HashMap<>(6);
        param.put("period", request.getPeriod());
        param.put("check", request.getCheck());
        param.put("begin", request.getBegin());
        param.put("end", request.getEnd());
        List<String> list;
        if (request.getPeriod().equals(periodDay)) {
            list = GetBetweenDates.getBetweenDate(request.getBegin(), request.getEnd());
        } else {
            list = GetBetweenDates.getMonthBetweenDate(request.getBegin(), request.getEnd());
        }
        param.put("list", list);

        if (statistics.equals(request.getCheck())) {
            orderStatisticsResponse = orderStatisticsMapper.orderStatistics(param);
        } else {
            orderStatisticsResponse = orderStatisticsMapper.selectOrderFlow(param);
        }
        return ResponseResult.success(orderStatisticsResponse);
    }
}
