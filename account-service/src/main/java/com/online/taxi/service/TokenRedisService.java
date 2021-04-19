package com.online.taxi.service;

/**
 * token redis 缓存服务
 *
 * @author dongjb
 * @date 2018/08/15
 **/
public interface TokenRedisService {

    /**
     * 存入token
     *
     * @param phoneNum 身份_电话号码_ID
     * @param token    token
     * @param expHours 失效小时
     */
    void put(String phoneNum, String token, Integer expHours);

    /**
     * 获取 token
     *
     * @param phoneNum 电话号码
     * @return token
     */
    String get(String phoneNum);

    /**
     * 设置失效时长
     *
     * @param phoneNum  电话号码
     * @param expHours 失效时长
     * @return 是否成功
     */
    Boolean expire(String phoneNum, Integer expHours);

    /**
     * 删除 token
     * @param phoneNum 电话号码
     */
    void delete(String phoneNum);


}
