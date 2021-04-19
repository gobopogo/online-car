package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.OrderDtoRequest;

/**
 * 抢单服务
 *
 * @author dongjb
 * @date 2021/04/16
 */

public interface OrderGrabService {

    /**
     * 司机抢单
     * @param orderRequest 订单申请对象
     * @return 返回对象
     * @throws Exception 异常
     */
    ResponseResult grab(OrderDtoRequest orderRequest) throws Exception;
}
