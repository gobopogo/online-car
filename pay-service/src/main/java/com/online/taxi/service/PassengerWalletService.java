package com.online.taxi.service;

import com.online.taxi.entity.PassengerWallet;
import com.online.taxi.entity.PassengerWalletRecord;

/**
 * 乘客钱包服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface PassengerWalletService {

    /**
     * 用户的余额变更
     *
     * @param yid          乘客标识
     * @param capital      本金
     * @param giveFee      赠额
     * @param changeStatus -1：减，1：加
     */
    void alterPassengerWalletPrice(Integer yid, Double capital, Double giveFee, int changeStatus);

    /**
     * 生成钱包记录
     *
     * @param yid         乘客标识
     * @param capital     本金
     * @param giveFee     赠额
     * @param payType     支付渠道
     * @param tradeType   交易类型
     * @param description 支付描述
     * @param orderId     订单号
     * @param payStatus   支付状态
     * @param createUser  创建用户
     * @return 乘客钱包流水
     */
    PassengerWalletRecord createWalletRecord(Integer yid, Double capital, Double giveFee,
                                             Integer payType, Integer tradeType, String description,
                                             Integer orderId, Integer payStatus, String createUser);

    /**
     * 支付完成处理逻辑
     *
     * @param rechargeType 支付类型
     * @param rechargeId   支付流水
     * @param tradeNo      订单号
     */
    void handleCallBack(int rechargeType, Integer rechargeId, String tradeNo);

    /**
     * 初始化乘客钱包
     *
     * @param passengerInfoId 乘客标识
     * @param capital         本金
     * @param giveFee         赠品
     * @return 乘客钱包
     */
    PassengerWallet initPassengerWallet(Integer passengerInfoId, Double capital, Double giveFee);

    /**
     * 解冻钱包
     *
     * @param yid           乘客标识
     * @param freezeCapital 冻结本金
     * @param freezeGiveFee 冻结赠品
     * @return 结果
     */
    int unfreezeWallet(Integer yid, Double freezeCapital, Double freezeGiveFee);
}
