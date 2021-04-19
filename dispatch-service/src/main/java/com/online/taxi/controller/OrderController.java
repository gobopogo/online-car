package com.online.taxi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.DispatchOrderRequest;
import com.online.taxi.request.DispatchRequest;
import com.online.taxi.schedule.TaskManager;
import com.online.taxi.service.DispatchService;

/**
 * 派单API
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/dispatch")
public class OrderController {
    @NonNull
    private final TaskManager taskManager;

    @RequestMapping("/")
    public String home() {
        return "dispatch";
    }

    /**
     * 派单
     *
     * @param request 订单号
     * @return 结果对象
     */
    @ResponseBody
    @RequestMapping(value = "/dispatchOrder", produces = "application/json; charset=utf-8")
    public ResponseResult dispatchOrder(@RequestBody DispatchOrderRequest request) {
        int orderId = request.getOrderId();
        taskManager.dispatch(orderId);
        return ResponseResult.success("success");
    }

    /**
     * 派单
     *
     * @param dispatchRequest 订单对象
     * @return 结果对象
     */
    @PostMapping("/vehicleDispatch")
    public ResponseResult dispatch(@RequestBody DispatchRequest dispatchRequest) {
        return DispatchService.ins().dispatch(dispatchRequest);
    }

}
