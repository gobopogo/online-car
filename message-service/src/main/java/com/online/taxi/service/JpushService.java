package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.push.PushRequest;

/**
 * 推送服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface JpushService {

    /**
     * 推送服务
     *
     * @param pushRequest 推送申请
     * @param channelType 消息类型
     * @return ResponseResult实例
     */
    ResponseResult<?> sendSingleJpushToApp(PushRequest pushRequest, int channelType);

}
