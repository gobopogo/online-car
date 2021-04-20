package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.OrderRequest;

/**
 * 订单统计服务
 *
 * @author dongjb
 * @date 2021/04/20
 */
public interface OrderStatisticsService {

    /**
     * 订单统计
     *
     * @param request 订单统计请求对象
     * @return ResponseResult实例
     */
    ResponseResult<?> orderStatistics(OrderRequest request);

}
