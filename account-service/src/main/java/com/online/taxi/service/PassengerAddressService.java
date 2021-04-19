package com.online.taxi.service;

import java.util.List;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerAddress;

/**
 * 乘客地址服务
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface PassengerAddressService {

    int deleteByPrimaryKey(Integer id);

    int insert(PassengerAddress record);

    int insertSelective(PassengerAddress record);

    PassengerAddress selectByPrimaryKey(Integer id);

    List<PassengerAddress> selectPassengerAddressList(Integer PassengerInfoId);

    PassengerAddress selectByAddPassengerInfoId(PassengerAddress passengerInfoId);

    int updateByPrimaryKeySelective(PassengerAddress record);

    ResponseResult updatePassengerAddress(PassengerAddress record);

    int updateByPrimaryKey(PassengerAddress record);
}
