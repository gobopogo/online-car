package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.OrderOtherPrice;
import com.online.taxi.dto.OrderPrice;
import com.online.taxi.request.OrderDtoRequest;
import com.online.taxi.service.OrderGrabService;
import com.online.taxi.service.OrderService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理
 *
 * @author dongjb
 * @date 2021/04/15
 **/
@RestController
@RequestMapping("/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    @NonNull
    private final OrderService orderService;

    @NonNull
    private final OrderGrabService orderGrabService;

    /**
     * 预估
     *
     * @param request 订单申请对象
     * @return 结果
     */
    @PostMapping("/forecast")
    public ResponseResult forecast(@RequestBody OrderDtoRequest request) {
        ResponseResult responseResult;
        try {
            responseResult = orderService.forecastOrderCreate(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("订单预估失败", e);
            responseResult = ResponseResult.fail("订单预估失败");
        }
        return responseResult;
    }

    /**
     * 叫车
     *
     * @param request 申请对象
     * @return 结果
     */
    @PostMapping("/callCar")
    public ResponseResult callCar(@RequestBody OrderDtoRequest request) {
        ResponseResult responseResult;
        try {
            responseResult = orderService.callCar(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("叫车失败", e);
            responseResult = ResponseResult.fail("叫车失败");
        }
        return responseResult;
    }

    /**
     * 派单、强派、修改订单
     *
     * @param orderDtoRequest 订单申请对象
     * @return 返回对象
     */
    @PostMapping("/updateOrder")
    public ResponseResult updateOrder(@RequestBody OrderDtoRequest orderDtoRequest) {
        ResponseResult responseResult;
        try {
            responseResult = orderService.updateOrder(orderDtoRequest, orderDtoRequest.getDriverLongitude(), orderDtoRequest.getDriverLatitude());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("操作失败", e);
            responseResult = ResponseResult.fail("操作失败");
        }
        return responseResult;
    }

    /**
     * 抢单
     *
     * @param request 订单申请对象
     * @return 返回对象
     */
    @PostMapping("/grab")
    public ResponseResult grab(@RequestBody OrderDtoRequest request) {
        ResponseResult<OrderPrice> responseResult;
        try {
            responseResult = orderGrabService.grab(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("抢单失败", e);
            responseResult = ResponseResult.fail("抢单失败");
        }
        return responseResult;
    }

    /**
     * 其它费用结算
     *
     * @param request 订单申请对象
     * @return 返回对象
     */
    @PostMapping("/otherPrice")
    public ResponseResult otherPriceBalance(@RequestBody OrderDtoRequest request) {
        ResponseResult<OrderOtherPrice> responseResult;
        try {
            responseResult = orderService.otherPriceBalance(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("其它费用操作失败", e);
            responseResult = ResponseResult.fail("操作失败");
        }
        return responseResult;
    }

    /**
     * 订单改派
     *
     * @param request 订单申请对象
     * @return 返回对象
     */
    @PostMapping("/reassignment")
    public ResponseResult reassignmentOrder(@RequestBody OrderDtoRequest request) {
        ResponseResult responseResult;
        try {
            responseResult = orderService.reassignmentOrder(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("订单改派失败", e);
            responseResult = ResponseResult.fail("订单改派失败");
        }
        return responseResult;
    }

    /**
     * 批量修改
     *
     * @param request  订单申请对象
     * @return 返回对象
     */
    @PostMapping("/batchUpdate")
    public ResponseResult batchUpdate(@RequestBody OrderDtoRequest request) {
        ResponseResult responseResult = null;
        try {
            responseResult = orderService.batchUpdate(request);
        } catch (Exception e) {
            log.error("修改失败", e);
            e.printStackTrace();
        }
        return responseResult;
    }

}
