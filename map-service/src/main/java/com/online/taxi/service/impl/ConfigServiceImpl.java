package com.online.taxi.service.impl;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.response.ConfigResponse;
import com.online.taxi.service.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 配置
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Value("${amap.sid}")
    private String amapSid;

    @Override
    public ResponseResult getSid() {
        ConfigResponse bean = new ConfigResponse();
        bean.setKey("");
        bean.setSid(amapSid);
        return ResponseResult.success(bean);
    }
}
