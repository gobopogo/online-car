package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.PayRequest;
import com.online.taxi.service.RechargeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 平台充值
 *
 * @author dongjb
 * @date 2021/04/19
 */
@RestController
@RequestMapping("/recharge")
@RequiredArgsConstructor
public class RechargeController {

    @NonNull
    private final RechargeService rechargeService;

    /**
     * boss充值
     *
     * @param payRequest 充值申请对象
     * @return ResponseResult实例
     */
    @PostMapping("/boss")
    public ResponseResult<?> refund(@RequestBody PayRequest payRequest) {

        Integer yid = payRequest.getYid();
        Double capital = payRequest.getCapital() == null ? 0 : payRequest.getCapital();
        Double giveFee = payRequest.getGiveFee() == null ? 0 : payRequest.getGiveFee();
        String createUser = payRequest.getCreateUser();
        return rechargeService.bossRecharge(yid, capital, giveFee, "后台充值", createUser);
    }
}
