package com.online.taxi.service.impl;

import com.online.taxi.constant.*;
import com.online.taxi.dao.PassengerWalletDao;
import com.online.taxi.dao.PassengerWalletRecordDao;
import com.online.taxi.entity.PassengerWallet;
import com.online.taxi.entity.PassengerWalletRecord;
import com.online.taxi.service.PassengerWalletService;
import com.online.taxi.util.BigDecimalUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 乘客钱包服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@Slf4j
@RequiredArgsConstructor
public class PassengerWalletServiceImpl implements PassengerWalletService {

    @NonNull
    private final PassengerWalletDao passengerWalletDao;

    @NonNull
    private final PassengerWalletRecordDao walletRecordDao;

    @Override
    public PassengerWalletRecord createWalletRecord(Integer yid, Double capital, Double giveFee,
                                                    Integer payType, Integer tradeType, String description,
                                                    Integer orderId, Integer payStatus, String createUser) {
        Date nowDate = new Date();
        PassengerWalletRecord passengerWalletRecord = new PassengerWalletRecord();
        passengerWalletRecord.setPassengerInfoId(yid);
        passengerWalletRecord.setPayTime(nowDate);
        passengerWalletRecord.setPayCapital(capital);
        passengerWalletRecord.setPayGiveFee(giveFee);

        Double sumMoney = BigDecimalUtil.add(capital.toString(), giveFee.toString());
        double discount = 0d;
        if (sumMoney.compareTo(PayConst.ZERO) > 0) {
            discount = BigDecimalUtil.div(giveFee.toString(), sumMoney.toString(), 2);
        }

        passengerWalletRecord.setRechargeDiscount(discount);
        passengerWalletRecord.setPayType(payType);
        passengerWalletRecord.setCreateTime(nowDate);
        passengerWalletRecord.setPayStatus(payStatus);
        passengerWalletRecord.setTradeType(tradeType);
        passengerWalletRecord.setDescription(description);
        passengerWalletRecord.setOrderId(orderId);
        passengerWalletRecord.setCreateUser(createUser);

        walletRecordDao.insertSelective(passengerWalletRecord);
        return passengerWalletRecord;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleCallBack(int rechargeType, Integer rechargeId, String tradeNo) {

        // 查询充值记录
        PassengerWalletRecord passengerWalletRecord = walletRecordDao.selectByPrimaryKey(rechargeId);
        Double capital = passengerWalletRecord.getPayCapital();
        Double giveFee = passengerWalletRecord.getPayGiveFee();

        Integer passengerInfoId = passengerWalletRecord.getPassengerInfoId();
        PassengerWallet passengerWallet = passengerWalletDao.selectByPassengerInfoId(passengerInfoId);
        //更新乘客钱包
        if (null == passengerWallet) {
            initPassengerWallet(passengerInfoId, capital, giveFee);
        }
        //更改流水记录
        passengerWalletRecord.setPayStatus(PayEnum.PAID.getCode());
        passengerWalletRecord.setTransactionId(tradeNo);
        walletRecordDao.updateByPrimaryKeySelective(passengerWalletRecord);
        //如果是充值，并消费，产生消费记录
        if (rechargeType == RechargeTypeEnum.CONSUME.getCode()) {

            createWalletRecord(passengerInfoId, capital, giveFee,
                    PayTypeEnum.BALANCE.getCode(), TradeTypeEnum.CONSUME.getCode(), "订单消费",
                    passengerWalletRecord.getOrderId(), PayEnum.PAID.getCode(), "");
        } else {
            alterPassengerWalletPrice(passengerInfoId, capital, giveFee, ChangeStatusEnum.ADD.getCode());

        }

    }

    @Override
    public PassengerWallet initPassengerWallet(Integer passengerInfoId, Double capital, Double giveFee) {
        Date nowTime = new Date();
        PassengerWallet passengerWallet = new PassengerWallet();
        passengerWallet.setPassengerInfoId(passengerInfoId);
        passengerWallet.setCapital(capital);
        passengerWallet.setGiveFee(giveFee);
        passengerWallet.setFreezeCapital(0d);
        passengerWallet.setFreezeGiveFee(0d);
        passengerWallet.setCreateTime(nowTime);
        passengerWallet.setUpdateTime(nowTime);
        passengerWalletDao.insertSelective(passengerWallet);
        return passengerWallet;
    }

    @Override
    public void alterPassengerWalletPrice(Integer yid, Double capital, Double giveFee, int changeStatus) {
        int count = 0;
        int maxCount = 100;
        while (count <= maxCount) {
            log.info("修改乘客钱包次数：" + count);
            PassengerWallet passengerWallet = passengerWalletDao.selectByPassengerInfoId(yid);
            Double capitalOld = passengerWallet.getCapital();
            Double giveFeeOld = passengerWallet.getGiveFee();

            double capitalNew;
            double giveFeeNew;
            if (changeStatus == ChangeStatusEnum.ADD.getCode()) {
                capitalNew = BigDecimalUtil.add(capitalOld.toString(), capital.toString());
                giveFeeNew = BigDecimalUtil.add(giveFeeOld.toString(), giveFee.toString());
            } else if (changeStatus == ChangeStatusEnum.SUB.getCode()) {
                capitalNew = BigDecimalUtil.sub(capitalOld.toString(), capital.toString());
                giveFeeNew = BigDecimalUtil.sub(giveFeeOld.toString(), giveFee.toString());
            } else {
                return;
            }
            int row = passengerWalletDao.updateBalanceBypassengerInfoId(yid, capitalNew, giveFeeNew, capitalOld, giveFeeOld);
            if (row == 0) {
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }

        }

    }

    @Override
    public int unfreezeWallet(Integer yid, Double freezeCapital, Double freezeGiveFee) {

        PassengerWallet passengerWallet = passengerWalletDao.selectByPassengerInfoId(yid);

        if (null != passengerWallet) {

            Double capitalOld = passengerWallet.getCapital();
            Double giveFeeOld = passengerWallet.getGiveFee();
            double capitalNew = BigDecimalUtil.add(capitalOld.toString(), freezeCapital.toString());
            double giveFeeNew = BigDecimalUtil.add(giveFeeOld.toString(), freezeGiveFee.toString());

            Double freezeCapitalOld = passengerWallet.getFreezeCapital();
            Double freezeGiveFeeOld = passengerWallet.getFreezeGiveFee();
            double freezeCapitalNew = BigDecimalUtil.sub(freezeCapitalOld.toString(), freezeCapital.toString());
            double freezeGiveFeeNew = BigDecimalUtil.sub(freezeGiveFeeOld.toString(), freezeGiveFee.toString());


            return passengerWalletDao.unfreezeBalanceByPassengerInfoId(yid, capitalNew, giveFeeNew, capitalOld, giveFeeOld, freezeCapitalNew, freezeGiveFeeNew, freezeCapitalOld, freezeGiveFeeOld);

        } else {
            return 0;
        }

    }
}
