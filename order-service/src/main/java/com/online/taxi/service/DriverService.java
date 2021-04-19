package com.online.taxi.service;

import com.online.taxi.entity.DriverInfo;

import java.util.List;

/**
 * 功能描述
 *
 * @author dongjb
 * @date 2018/8/28
 */

public interface DriverService {

    /**
     * 查询司机
     *
     * @return 司机信息列表
     */
    List<DriverInfo> selectDriverList();
}
