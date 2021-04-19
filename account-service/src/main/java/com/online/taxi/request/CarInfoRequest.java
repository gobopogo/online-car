package com.online.taxi.request;

import com.online.taxi.dto.CarBaseInfoView;

import lombok.Data;

/**
 * 车辆信息
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class CarInfoRequest {

    private CarBaseInfoView data;
}
