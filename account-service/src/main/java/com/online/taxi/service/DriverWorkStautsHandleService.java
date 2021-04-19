package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.DriverWorkStatusRequest;

/**
 * 司机工作状态处理
 *
 * @author dongjb
 * @date 2018/9/5
 **/
public interface DriverWorkStautsHandleService {

    /**
     * @param driverWorkStatusRequest 对象
     * @return ResponseResult实例
     */
    ResponseResult changeWorkStatus(DriverWorkStatusRequest driverWorkStatusRequest);
}
