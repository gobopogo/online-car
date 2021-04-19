package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.DriverBaseInfo;

/**
 * 司机基本信息mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface DriverBaseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DriverBaseInfo record);

    int insertSelective(DriverBaseInfo record);

    DriverBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DriverBaseInfo record);

    int updateByPrimaryKey(DriverBaseInfo record);
}
