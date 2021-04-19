package com.online.taxi.request;

import lombok.Data;

/**
 * 修改司机状态
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class UpdateDriverStatusRequest {

    private Integer id;

    private Integer useStatus;

    private Integer signStatus;

    private Integer carId;
}
