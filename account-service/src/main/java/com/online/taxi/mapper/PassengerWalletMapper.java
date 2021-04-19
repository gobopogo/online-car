package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.PassengerWallet;

/**
 * 乘客钱包mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface PassengerWalletMapper {

    int insertSelective(PassengerWallet record);

}
