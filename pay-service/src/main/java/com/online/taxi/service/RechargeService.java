package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;

/**
 * 平台充值服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface RechargeService {

    /**
     * 后台充值
     *
     * @param yid         乘客标识
     * @param capital     本金
     * @param giveFee     赠金
     * @param description 描述
     * @param createUser  创建用户
     * @return ResponseResult实例
     */
    ResponseResult<?> bossRecharge(Integer yid, Double capital, Double giveFee, String description, String createUser);

}
