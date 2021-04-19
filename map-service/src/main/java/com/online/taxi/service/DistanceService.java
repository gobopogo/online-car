package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.Route;
import com.online.taxi.dto.map.request.DistanceRequest;

/**
 * 地图距离测量
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface DistanceService {
    /**
     * 测量距离
     *
     * @param distanceRequest 距离测量请求
     * @return 返回对象
     */
    ResponseResult<Route> distance(DistanceRequest distanceRequest);

}
