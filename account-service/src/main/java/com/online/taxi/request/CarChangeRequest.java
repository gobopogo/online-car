package com.online.taxi.request;

import com.online.taxi.dto.CarBaseInfoView;

import lombok.Data;

/**
 * 车辆变更请求
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class CarChangeRequest {

    private CarBaseInfoView data;

}
