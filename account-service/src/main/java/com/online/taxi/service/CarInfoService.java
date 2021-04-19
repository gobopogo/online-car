package com.online.taxi.service;

import java.util.Map;

import com.online.taxi.entity.CarInfo;

/**
 * 车辆服务
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface CarInfoService {

    int deleteByPrimaryKey(Integer id);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    int countCarInfo(Map<String, Object> param);
}
