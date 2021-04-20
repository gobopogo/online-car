package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.RefundRequest;
import com.online.taxi.service.RefundService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 退款
 *
 * @author dongjb
 * @date 2021/04/19
 */
@RestController
@RequestMapping("/refund")
@RequiredArgsConstructor
public class RefundController {

    @NonNull
    private final RefundService refundService;

    /**
     * 订单退款
     *
     * @param refundRequest 退款申请对象
     * @return ResponseResult实例
     */
    @PostMapping("/order")
    public ResponseResult<?> refund(@RequestBody RefundRequest refundRequest) {

        Integer yid = refundRequest.getYid();
        Integer orderId = refundRequest.getOrderId();
        Double refundPrice = refundRequest.getRefundPrice();
        String createUser = refundRequest.getCreateUser();
        return refundService.refund(yid, orderId, refundPrice, createUser);

    }
}
