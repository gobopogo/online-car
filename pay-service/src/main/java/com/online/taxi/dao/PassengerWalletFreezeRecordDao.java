package com.online.taxi.dao;

import com.online.taxi.entity.PassengerWalletFreezeRecord;
import com.online.taxi.mapper.PassengerWalletFreezeRecordMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 乘客钱包冻结明细Dao
 *
 * @author dongjb
 * @date 2021/02/20
 */
@Repository
@RequiredArgsConstructor
public class PassengerWalletFreezeRecordDao {

    @NonNull
    private final PassengerWalletFreezeRecordMapper passengerWalletFreezeRecordMapper;

    public int insertSelective(PassengerWalletFreezeRecord record) {
        return passengerWalletFreezeRecordMapper.insertSelective(record);
    }

    public PassengerWalletFreezeRecord selectByPrimaryKey(Integer id) {
        return passengerWalletFreezeRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PassengerWalletFreezeRecord record) {
        return passengerWalletFreezeRecordMapper.updateByPrimaryKeySelective(record);
    }

    public PassengerWalletFreezeRecord selectByOrderIdAndYid(Integer orderId, Integer passengerInfoId) {
        Map<String, Object> param = new HashMap<>(2);
        param.put("orderId", orderId);
        param.put("passengerInfoId", passengerInfoId);
        return passengerWalletFreezeRecordMapper.selectByOrderIdAndYid(param);
    }
}
