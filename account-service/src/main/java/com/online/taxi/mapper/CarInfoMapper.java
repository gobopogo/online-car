package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.CarInfo;

import java.util.Map;

/**
 * 车辆信息mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface CarInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    int countCarInfo(Map<String, Object> param);
}
