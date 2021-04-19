package com.online.taxi.request;

import lombok.Data;

/**
 * 司机工作状态
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class DriverWorkStatusRequest {

    private Integer id;

    private Integer workStatus;

    private Integer csWorkStatus;

    private Integer isFollowing;

    private Integer status;

    private Double longitude;

    private Double latitude;

    private String city;

    private Double speed;

    private Double accuracy;

    private Double direction;

    private Double height;

    private Integer locationType;

    private String phoneNum;

}
