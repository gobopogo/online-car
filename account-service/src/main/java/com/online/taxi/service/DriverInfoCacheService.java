package com.online.taxi.service;

/**
 * 司机信息缓存服务
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface DriverInfoCacheService {

    /**
     * 查询司机信息
     *
     * @param phoneNum 手机号
     * @return string
     */
    String get(String phoneNum);

    /**
     * 保存司机信息
     *
     * @param phoneNum   手机号
     * @param driverInfo 对象
     */
    void put(String phoneNum, String driverInfo);

}
