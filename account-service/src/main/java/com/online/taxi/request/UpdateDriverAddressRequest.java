package com.online.taxi.request;

import lombok.Data;

/**
 * 司机更新地址请求对象
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class UpdateDriverAddressRequest {

    private Integer id;

    private String phoneNumber;

    private String addressLongitude;

    private String addressLatitude;

    private String address;
}
