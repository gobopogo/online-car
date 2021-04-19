package com.online.taxi.dto.map;

import lombok.Data;

/**
 * 地图基本返回对象
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Data
public class BaseResponse {

    private int errcode;

    private String errmsg;
}
