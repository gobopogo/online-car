package com.online.taxi.service;

import com.online.taxi.dto.SmsSendRequest;

/**
 * 短信发送服务
 *
 * @author dongjb
 * @date 2021/04/18
 */
public interface SmsService {

    /**
     * 发送短信
     * @param request 短信内容
     */
    void sendSms(SmsSendRequest request);

}
