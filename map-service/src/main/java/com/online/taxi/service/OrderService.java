package com.online.taxi.service;

import com.online.taxi.dto.map.request.OrderRequest;

/**
 * 订单服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface OrderService {

    /**
     * 同步订单
     *
     * @param orderRequest 订单申请
     * @return 结果
     */
    String order(OrderRequest orderRequest);
}
