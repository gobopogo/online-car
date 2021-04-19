package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.GetTokenRequest;

/**
 * 司机登录服务
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface DriverRegistHandleService {

    ResponseResult checkIn(GetTokenRequest getTokenRequest);

}
