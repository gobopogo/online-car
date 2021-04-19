package com.online.taxi.response;

import lombok.Data;

/**
 * 司机登录返回对象
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class DriverRegistResponse {

    private String accessToken;

    private String phoneNumber;

    private Integer gerder;

    private String driverName;

    private Integer checkStatus;

    private String headImg;

    private Integer driverId;

    private String jpushId;

    private String workStatus;

}
