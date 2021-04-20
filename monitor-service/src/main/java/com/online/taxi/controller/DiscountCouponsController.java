package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.DiscountCouponsRequest;
import com.online.taxi.service.DiscountCouponsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 优惠券
 *
 * @author dongjb
 * @date 2020/04/20
 */
@RestController
@RequestMapping("/discount_coupons")
@Slf4j
@RequiredArgsConstructor
public class DiscountCouponsController {

    @NonNull
    private final DiscountCouponsService discountCouponsService;

    /**
     * 优惠券统计
     *
     * @param request 优惠券统计申请对象
     * @return ResponseResult实例
     */
    @PostMapping("/statistics")
    public ResponseResult<?> discountCouponsStatistics(@RequestBody DiscountCouponsRequest request) {
        return discountCouponsService.discountCouponsStatistics(request);
    }
}
