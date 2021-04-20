package com.online.taxi.mapper;

import com.online.taxi.response.OrderStatisticsResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单统计mapper
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Mapper
@Service
public interface OrderStatisticsMapper {

    /**
     * 订单统计
     *
     * @param param 统计参数
     * @return 统计结果列表
     */
    List<OrderStatisticsResponse> orderStatistics(Map<String, Object> param);

    /**
     * 流水统计
     *
     * @param param 统计结果
     * @return 统计结果列表
     */
    List<OrderStatisticsResponse> selectOrderFlow(Map<String, Object> param);
}
