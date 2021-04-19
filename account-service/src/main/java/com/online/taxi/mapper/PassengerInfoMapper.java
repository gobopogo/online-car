package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.PassengerInfo;

import java.util.List;
import java.util.Map;

/**
 * 乘客信息mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface PassengerInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PassengerInfo record);

    int insertSelective(PassengerInfo record);

    PassengerInfo selectByPrimaryKey(Integer id);

    List<PassengerInfo> selectByPrimaryKeyList();

    int updateByPrimaryKeySelective(PassengerInfo record);

    int updateByPrimaryKey(PassengerInfo record);

    PassengerInfo queryPassengerInfoByPhoneNum(String phoneNum);

    int updatePassengerBalance(Map<String, Object> map);

    void updatePassengerInfoLoginTime(Integer passengerId);
}
