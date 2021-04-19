package com.online.taxi.mapper;

import org.springframework.stereotype.Service;

import com.online.taxi.entity.DriverLicenceInfo;

/**
 * 司机牌照信息mapper
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Service
public interface DriverLicenceInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DriverLicenceInfo record);

    int insertSelective(DriverLicenceInfo record);

    DriverLicenceInfo selectByPrimaryKey(Integer id);

    DriverLicenceInfo selectByDriverId(Integer driverId);

    int updateByPrimaryKeySelective(DriverLicenceInfo record);

    int updateByDriverIdSelective(DriverLicenceInfo record);

    int updateByPrimaryKey(DriverLicenceInfo record);
}
