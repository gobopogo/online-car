package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.sms.SmsRequest;

/**
 * 华信短信发送
 *
 * @author dongjb
 * @date 2021/04/18
 */
public interface HxSmsService {

    /**
     * 短信发送
     *
     * @param request 短信请求
     * @return ResponseResult实例
     */
    ResponseResult<?> sendSms(SmsRequest request);
}
