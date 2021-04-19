package com.online.taxi.service;

import com.online.taxi.dto.CarBaseInfoView;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.CarBaseInfo;

/**
 * 车辆服务
 *
 * @author dongjb
 * @date 2018/08/15
 */
public interface CarBaseService {

    /**
     * 更改车辆
     *
     * @param view CarBaseInfo 对象
     * @return 成功失败
     */
    int updateCarBaseInfoView(CarBaseInfo view);

    /**
     * 添加车辆
     *
     * @param view
     * @return
     */
    ResponseResult addCarBaseInfo(CarBaseInfoView view);

}
