package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.OrderOtherPrice;
import com.online.taxi.dto.OrderPrice;
import com.online.taxi.request.OrderDtoRequest;

/**
 * 订单服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface OrderService {

    /**
     * 订单预估
     *
     * @param request 订单申请
     * @return  结果
     * @throws Exception 异常
     */
    ResponseResult<OrderPrice> forecastOrderCreate(OrderDtoRequest request) throws Exception;

    /**
     * 叫车
     *
     * @param request 订单申请
     * @return 结果
     * @throws Exception 异常
     */
    ResponseResult<Object> callCar(OrderDtoRequest request) throws Exception;

    /**
     * 订单修改
     *
     * @param orderDtoRequest 订单申请
     * @param driverLongitude 司机经度
     * @param driverLatitude 司机纬度
     * @return 结果
     */
    ResponseResult<Object> updateOrder(OrderDtoRequest orderDtoRequest, String driverLongitude, String driverLatitude);

    /**
     * 其它费用结算
     *
     * @param request 订单申请
     * @return 结果
     * @throws Exception 异常
     */
    ResponseResult<OrderOtherPrice> otherPriceBalance(OrderDtoRequest request) throws Exception;

    /**
     * 订单改派
     *
     * @param request 订单申请
     * @return 结果
     * @throws Exception 异常
     */
    ResponseResult<Object> reassignmentOrder(OrderDtoRequest request) throws Exception;

    /**
     * 批量修改
     *
     * @param request 订单申请
     * @return 结果
     * @throws Exception 异常
     */
    ResponseResult<Object> batchUpdate(OrderDtoRequest request) throws Exception;

}
