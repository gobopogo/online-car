package com.online.taxi.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import com.online.taxi.entity.PassengerWallet;
import com.online.taxi.mapper.PassengerWalletMapper;

/**
 * 乘客钱包DAO
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Repository
@RequiredArgsConstructor
public class PassengerWalletDao {

    @NonNull
    private final PassengerWalletMapper passengerWalletMapper;

    public int insertSelective(PassengerWallet record) {
        return passengerWalletMapper.insertSelective(record);
    }

}
