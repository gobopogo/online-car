package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.OrderRequest;
import com.online.taxi.service.OrderStatisticsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单统计
 *
 * @author dongjb
 * @date 2021/04/20
 */
@RestController
@RequestMapping("/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    @NonNull
    private final OrderStatisticsService orderStatisticsService;

    @PostMapping("/order_statistics")
    public ResponseResult<?> orderStatistics(@RequestBody OrderRequest request) {
        return orderStatisticsService.orderStatistics(request);
    }
}
