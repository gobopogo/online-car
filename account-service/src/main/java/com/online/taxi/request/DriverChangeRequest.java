package com.online.taxi.request;

import lombok.Data;

import java.util.Date;

import com.online.taxi.dto.DriverBaseInfoView;

/**
 * 司机变更请求对象
 *
 * @author dongjb
 * @date 2018/08/15
 **/
@Data
public class DriverChangeRequest {

    private DriverBaseInfoView data;

    private int id;

    private int driverStatus;

    private int carId;

    private Date searchCreateStartTime;

    private Date searchCreateEndTime;

    private String address;

}
