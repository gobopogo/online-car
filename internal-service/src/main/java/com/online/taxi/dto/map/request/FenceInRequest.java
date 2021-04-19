package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * 在围栏内申请对象
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class FenceInRequest {

    private String longitude;

    private String latitude;

    private String diu;

}
