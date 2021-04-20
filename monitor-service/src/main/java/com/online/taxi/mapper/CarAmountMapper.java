package com.online.taxi.mapper;

import com.online.taxi.response.CarAmountResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆统计mapper
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Mapper
@Service
public interface CarAmountMapper {

    /**
     * 车辆统计
     *
     * @param param 统计参数
     * @return 统计结果
     */
    List<CarAmountResponse> carAmount(Map<String, Object> param);
}
