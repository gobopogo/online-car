package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.UserRequest;

/**
 * 用户统计查询
 *
 * @author dongjb
 * @date 2021/04/20
 */
public interface UserStatisticsService {

    /**
     * 用户统计
     *
     * @param request 申请对象
     * @return ResponseResult实例
     */
    ResponseResult<?> userStatistics(UserRequest request);
}
