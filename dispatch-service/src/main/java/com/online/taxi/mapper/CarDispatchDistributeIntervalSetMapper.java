package com.online.taxi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.online.taxi.entity.CarDispatchDistributeIntervalSet;

/**
 * 派单服务间隔设置
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Mapper
public interface CarDispatchDistributeIntervalSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarDispatchDistributeIntervalSet record);

    int insertSelective(CarDispatchDistributeIntervalSet record);

    CarDispatchDistributeIntervalSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarDispatchDistributeIntervalSet record);

    int updateByPrimaryKey(CarDispatchDistributeIntervalSet record);

    CarDispatchDistributeIntervalSet selectByCityCodeAndServiceType(@Param("cityCode") String cityCode, @Param("serviceTypeId") Integer serviceTypeId);
}
