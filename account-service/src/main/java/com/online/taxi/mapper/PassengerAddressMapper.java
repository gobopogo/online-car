package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.PassengerAddress;

import java.util.List;

/**
 * 乘客地址mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface PassengerAddressMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PassengerAddress record);

    int insertSelective(PassengerAddress record);

    PassengerAddress selectByPrimaryKey(Integer id);

    PassengerAddress selectByPassengerInfoId(Integer passengerInfoId);

    List<PassengerAddress> selectPassengerAddressList(Integer PassengerInfoId);

    PassengerAddress selectByAddPassengerInfoId(PassengerAddress passengerInfoId);

    int updateByPrimaryKeySelective(PassengerAddress record);

    int updatePassengerAddress(PassengerAddress record);

    int updateByPrimaryKey(PassengerAddress record);
}
