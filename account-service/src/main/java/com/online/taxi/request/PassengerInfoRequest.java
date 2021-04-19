package com.online.taxi.request;

import com.online.taxi.dto.PassengerInfoView;

import lombok.Data;

/**
 * 乘客请求信息
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class PassengerInfoRequest {

    private Integer id;

    private PassengerInfoView data;
}
