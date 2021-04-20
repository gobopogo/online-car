package com.online.taxi.dao;

import com.online.taxi.entity.PassengerWallet;
import com.online.taxi.mapper.PassengerWalletMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 乘客钱包Dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class PassengerWalletDao {

    @NonNull
    private final PassengerWalletMapper passengerWalletMapper;

    public PassengerWallet selectByPassengerInfoId(Integer passengerInfoId) {
        return passengerWalletMapper.selectByPassengerInfoId(passengerInfoId);
    }

    public int insertSelective(PassengerWallet record) {
        return passengerWalletMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(PassengerWallet record) {
        return passengerWalletMapper.updateByPrimaryKeySelective(record);
    }

    public int updateBalanceBypassengerInfoId(Integer passengerInfoId, double capitalNew, double giveFeeNew, double capitalOld,
                                              double giveFeeOld) {
        Map<String, Object> param = new HashMap<>(4);
        param.put("capitalNew", capitalNew);
        param.put("giveFeeNew", giveFeeNew);
        param.put("capitalOld", capitalOld);
        param.put("giveFeeOld", giveFeeOld);
        param.put("passengerInfoId", passengerInfoId);
        return passengerWalletMapper.updateBalanceByPassengerInfoId(param);
    }

    public int unfreezeBalanceByPassengerInfoId(Integer passengerInfoId, double capitalNew, double giveFeeNew, double capitalOld,
                                                double giveFeeOld, double freezeCapitalNew, double freezeGiveFeeNew, double freezeCapitalOld, double freezeGiveFeeOld) {
        Map<String, Object> param = new HashMap<>(4);
        param.put("capitalNew", capitalNew);
        param.put("giveFeeNew", giveFeeNew);
        param.put("capitalOld", capitalOld);
        param.put("giveFeeOld", giveFeeOld);

        param.put("freezeCapitalNew", freezeCapitalNew);
        param.put("freezeCapitalOld", freezeCapitalOld);
        param.put("freezeGiveFeeNew", freezeGiveFeeNew);
        param.put("freezeGiveFeeOld", freezeGiveFeeOld);

        param.put("passengerInfoId", passengerInfoId);
        return passengerWalletMapper.unfreezeBalanceByPassengerInfoId(param);
    }
}
