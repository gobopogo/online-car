package com.online.taxi.dao;

import com.online.taxi.entity.PassengerWalletRecord;
import com.online.taxi.mapper.PassengerWalletRecordMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 乘客钱包流水Dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class PassengerWalletRecordDao {

    @NonNull
    private final PassengerWalletRecordMapper passengerWalletRecordMapper;

    public int insertSelective(PassengerWalletRecord record) {
        return passengerWalletRecordMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(PassengerWalletRecord record) {
        return passengerWalletRecordMapper.updateByPrimaryKeySelective(record);
    }

    public PassengerWalletRecord selectByPrimaryKey(Integer id) {
        return passengerWalletRecordMapper.selectByPrimaryKey(id);
    }

    public List<PassengerWalletRecord> selectPaidRecordByOrderId(Integer orderId) {
        return passengerWalletRecordMapper.selectPaidRecordByOrderId(orderId);
    }
}
