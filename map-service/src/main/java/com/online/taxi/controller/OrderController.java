package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.OrderRequest;
import com.online.taxi.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 高德订单
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    @NonNull
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseResult order(@RequestBody OrderRequest orderRequest) {
        String result = orderService.order(orderRequest);
        return ResponseResult.success(result);
    }
}
