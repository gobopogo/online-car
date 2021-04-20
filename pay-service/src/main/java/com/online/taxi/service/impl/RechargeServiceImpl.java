package com.online.taxi.service.impl;

import com.online.taxi.constant.*;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerWalletRecord;
import com.online.taxi.service.CommonPayService;
import com.online.taxi.service.PassengerWalletService;
import com.online.taxi.service.RechargeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 平台充值服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Service
@RequiredArgsConstructor
public class RechargeServiceImpl implements RechargeService {

    @NonNull
    private final PassengerWalletService passengerWalletService;

    @NonNull
    private final CommonPayService commonPayService;

    @Override
    public ResponseResult<?> bossRecharge(Integer yid, Double capital, Double giveFee, String description, String createUser) {

        description = commonPayService.createDescription(capital, giveFee, description);
        PassengerWalletRecord passengerWalletRecord = passengerWalletService.createWalletRecord(yid, capital, giveFee,
                PayTypeEnum.SYSTEM.getCode(), TradeTypeEnum.RECHARGE.getCode(), description,
                null, PayEnum.UN_PAID.getCode(), createUser);

        passengerWalletService.handleCallBack(RechargeTypeEnum.CHARGE.getCode(), passengerWalletRecord.getId(), "");
        return ResponseResult.success("");
    }
}
