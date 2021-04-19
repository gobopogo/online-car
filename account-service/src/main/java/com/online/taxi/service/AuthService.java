package com.online.taxi.service;

/**
 * token服务
 * @author dongjb
 * @date 2021/04/14
 **/
public interface AuthService {

    /**
     * 生成验证码
     * @param phoneNum 身份_电话号码_ID
     * @return string
     */

    String createToken(String phoneNum);

    /**
     * 检查验证码
     * @param token token
     * @return string
     */
    String checkToken(String token);

    /**
     * 删除验证码
     * @param subject subject
     */
    void deleteToken(String subject);
}
