package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.CarBaseInfo;

/**
 * 车辆基本信息maper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface CarBaseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CarBaseInfo record);

    int insertSelective(CarBaseInfo record);

    CarBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBaseInfo record);

    int updateByPrimaryKey(CarBaseInfo record);
}
