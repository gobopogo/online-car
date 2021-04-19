package com.online.taxi.request;

import lombok.Data;

/**
 * 车辆信息
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class UpdateCarRequest {

    private Integer id;

    private Integer useStatus;

    private Integer totalMile;
}
