package com.online.taxi.service;

import com.online.taxi.dto.map.Distance;
import com.online.taxi.dto.map.Points;

/**
 * 高德路径服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface RouteService {
    /**
     * 查询指定车辆，在某个时间段内的里程
     *
     * @param carId     车辆标识
     * @param city      城市
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 路径长度
     */
    Distance getRoute(String carId, String city, Long startTime, Long endTime);

    /**
     * 查询指定车辆，在某个时间段内轨迹集合
     *
     * @param carId 车辆标识
     * @param city 城市
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 坐标点集合
     */
    Points getPointsAllPage(String carId, String city, Long startTime, Long endTime, String correction);


}
