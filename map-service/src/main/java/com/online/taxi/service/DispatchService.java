package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.DispatchRequest;

/**
 * 调度车辆服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface DispatchService {

    /**
     * 调度车辆
     *
     * @param dispatchRequest
     * @return 返回对象
     */
    ResponseResult dispatch(DispatchRequest dispatchRequest);
}
