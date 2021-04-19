package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * 地理请求
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class GeoRequest {
    private String longitude;
    private String latitude;
}
