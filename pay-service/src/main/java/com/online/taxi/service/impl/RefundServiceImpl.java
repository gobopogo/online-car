package com.online.taxi.service.impl;

import com.online.taxi.constant.*;
import com.online.taxi.dao.PassengerWalletRecordDao;
import com.online.taxi.dto.RefundPrice;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerWalletRecord;
import com.online.taxi.response.RefundResponse;
import com.online.taxi.service.PassengerWalletService;
import com.online.taxi.service.RefundService;
import com.online.taxi.util.BigDecimalUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 退款服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    @NonNull
    private final PassengerWalletRecordDao walletRecordDao;

    @NonNull
    private final PassengerWalletService passengerWalletService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<?> refund(Integer yid, Integer orderId, Double refundPrice, String createUser) {

        if (refundPrice == null || refundPrice.compareTo(0d) <= 0) {
            //没必要退款
            return ResponseResult.fail(ResponseStatusEnum.REFUND_MONEY_ERROR.getCode(), ResponseStatusEnum.REFUND_MONEY_ERROR.getValue());
        }

        //算出退款的本金，和赠费
        RefundPrice returnPrice = getRefundPrice(orderId, refundPrice);
        if (returnPrice == null) {
            return ResponseResult.fail(ResponseStatusEnum.REFUND_PAID_RECORD_EMPTY.getCode(), ResponseStatusEnum.REFUND_PAID_RECORD_EMPTY.getValue());
        }
        Double refundCapital = returnPrice.getRefundCapital();
        Double refundGiveFee = returnPrice.getRefundGiveFee();
        String description = "";
        if (refundCapital.compareTo(PayConst.ZERO) > 0 && refundGiveFee.compareTo(PayConst.ZERO) > 0) {
            description = "订单退款（本金+赠额）";
        } else if (refundCapital.compareTo(PayConst.ZERO) > 0) {
            description = "订单退款（本金）";
        } else if (refundGiveFee.compareTo(PayConst.ZERO) > 0) {
            description = "订单退款（赠额）";
        }
        if (refundCapital.compareTo(PayConst.ZERO) == 0 && refundGiveFee.compareTo(PayConst.ZERO) == 0) {
            return ResponseResult.fail(ResponseStatusEnum.REFUND_PAID_RECORD_MONEY_ZERO.getCode(), ResponseStatusEnum.REFUND_PAID_RECORD_MONEY_ZERO.getValue());
        }
        //生成退款记录
        PassengerWalletRecord passengerWalletRecord = passengerWalletService.createWalletRecord(yid, refundCapital, refundGiveFee,
                PayTypeEnum.SYSTEM.getCode(), TradeTypeEnum.REFUND.getCode(),
                description, orderId, PayEnum.PAID.getCode(), createUser);

        //回冲
        passengerWalletService.alterPassengerWalletPrice(yid, refundCapital, refundGiveFee, ChangeStatusEnum.ADD.getCode());
        RefundResponse response = new RefundResponse();
        response.setId(passengerWalletRecord.getId());
        return ResponseResult.success(response);
    }

    private RefundPrice getRefundPrice(Integer orderId, Double refundPrice) {
        double refundCapital = 0d;
        double refundGiveFee = 0d;
        RefundPrice refundPriceBean = new RefundPrice(0d, 0d);
        List<PassengerWalletRecord> walletRecords = walletRecordDao.selectPaidRecordByOrderId(orderId);
        if (walletRecords.isEmpty()) {
            return null;
        } else {
            //计算所有剩余可退的钱
            double remainGiveFeeAll = 0d;
            double remainCapitalAll = 0d;
            for (PassengerWalletRecord passengerWalletRecord : walletRecords) {
                double tempCapital = BigDecimalUtil.sub(passengerWalletRecord.getPayCapital().toString(), passengerWalletRecord.getRefundCapital().toString());
                remainCapitalAll = BigDecimalUtil.add(Double.toString(remainCapitalAll), Double.toString(tempCapital));

                double tempGiveFee = BigDecimalUtil.sub(passengerWalletRecord.getPayGiveFee().toString(), passengerWalletRecord.getRefundGiveFee().toString());
                remainGiveFeeAll = BigDecimalUtil.add(Double.toString(remainGiveFeeAll), Double.toString(tempGiveFee));
            }
            Double remainAll = BigDecimalUtil.add(Double.toString(remainCapitalAll), Double.toString(remainGiveFeeAll));
            if (refundPrice.compareTo(remainAll) > 0) {
                return null;
            }
            //此订单有支付记录
            for (PassengerWalletRecord passengerWalletRecord : walletRecords
            ) {
                //记录付过的钱
                Double payCapital = passengerWalletRecord.getPayCapital();
                Double payGiveFee = passengerWalletRecord.getPayGiveFee();
                //记录退过的钱
                Double recordRefundCapital = passengerWalletRecord.getRefundCapital();
                Double recordRefundGiveFee = passengerWalletRecord.getRefundGiveFee();

                //剩余可退
                double remainCapital = BigDecimalUtil.sub(payCapital.toString(), recordRefundCapital.toString());
                Double remainGiveFee = BigDecimalUtil.sub(payGiveFee.toString(), recordRefundGiveFee.toString());
                Double sumRemain = BigDecimalUtil.add(Double.toString(remainCapital), remainGiveFee.toString());
                if (sumRemain.compareTo(0d) <= 0) {
                    continue;
                }
                if (refundPrice.compareTo(remainGiveFee) <= 0) {

                    refundGiveFee = BigDecimalUtil.add(Double.toString(refundGiveFee), refundPrice.toString());
                    //更新已退的赠费
                    Double alreadyRefundGiveFee = BigDecimalUtil.add(recordRefundGiveFee.toString(), refundPrice.toString());
                    passengerWalletRecord.setRefundGiveFee(alreadyRefundGiveFee);
                    walletRecordDao.updateByPrimaryKeySelective(passengerWalletRecord);
                    break;
                } else if (refundPrice.compareTo(sumRemain) <= 0) {
                    //可退的赠费 总
                    refundGiveFee = BigDecimalUtil.add(Double.toString(refundGiveFee), remainGiveFee.toString());
                    //剩余需要退还的本金
                    double remainTemp = BigDecimalUtil.sub(refundPrice.toString(), remainGiveFee.toString());
                    refundCapital = BigDecimalUtil.add(Double.toString(refundCapital), Double.toString(remainTemp));
                    //更新已退的赠费
                    Double alreadyRefundGiveFee = BigDecimalUtil.add(recordRefundGiveFee.toString(), remainGiveFee.toString());
                    passengerWalletRecord.setRefundGiveFee(alreadyRefundGiveFee);
                    Double alreadyRefundCapital = BigDecimalUtil.add(recordRefundCapital.toString(), Double.toString(remainTemp));
                    passengerWalletRecord.setRefundCapital(alreadyRefundCapital);
                    walletRecordDao.updateByPrimaryKeySelective(passengerWalletRecord);
                    break;
                } else {
                    //可退的钱
                    refundGiveFee = BigDecimalUtil.add(Double.toString(refundGiveFee), remainGiveFee.toString());
                    refundCapital = BigDecimalUtil.add(Double.toString(refundCapital), Double.toString(remainCapital));
                    //更新已退的钱
                    Double alreadyRefundGiveFee = BigDecimalUtil.add(recordRefundGiveFee.toString(), remainGiveFee.toString());
                    passengerWalletRecord.setRefundGiveFee(alreadyRefundGiveFee);
                    Double alreadyRefundCapital = BigDecimalUtil.add(recordRefundCapital.toString(), Double.toString(remainCapital));
                    passengerWalletRecord.setRefundCapital(alreadyRefundCapital);
                    walletRecordDao.updateByPrimaryKeySelective(passengerWalletRecord);

                    double sumTemp = BigDecimalUtil.add(Double.toString(refundGiveFee), Double.toString(refundCapital));
                    refundPrice = BigDecimalUtil.sub(refundPrice.toString(), Double.toString(sumTemp));
                }

            }
        }

        refundPriceBean.setRefundCapital(refundCapital);
        refundPriceBean.setRefundGiveFee(refundGiveFee);
        return refundPriceBean;
    }
}
