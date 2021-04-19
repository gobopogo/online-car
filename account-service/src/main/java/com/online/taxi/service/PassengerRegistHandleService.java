package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.GetTokenRequest;

/**
 * 乘客注册处理
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface PassengerRegistHandleService {

    /**
     * 乘客登录
     * @param getTokenRequest 实例
     * @return ResponseResult 实例
     */
    ResponseResult handle(GetTokenRequest getTokenRequest);

    /**
     * 登出
     * @param request getTokenRequest 实例
     * @return ResponseResult 实例
     * @throws Exception 异常
     */
    ResponseResult checkOut(GetTokenRequest request) throws Exception;
}
