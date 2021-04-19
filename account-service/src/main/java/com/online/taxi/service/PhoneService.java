package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.PhoneRequest;

/**
 * 手机服务
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface PhoneService {

    ResponseResult getDecryptById(PhoneRequest request);

    ResponseResult createEncrypt(PhoneRequest request);

    ResponseResult getPhoneByEncryptList(PhoneRequest request);
}
