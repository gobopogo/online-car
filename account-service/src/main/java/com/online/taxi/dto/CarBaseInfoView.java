package com.online.taxi.dto;

import com.online.taxi.entity.CarBaseInfo;
import com.online.taxi.entity.CarInfo;

import lombok.Data;

/**
 * 车辆信息
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class CarBaseInfoView {

    private CarBaseInfo carBaseInfo;

    private CarInfo carInfo;

}
