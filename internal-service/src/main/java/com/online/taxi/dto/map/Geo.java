package com.online.taxi.dto.map;

import lombok.Data;

/**
 * 地理信息
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Geo {
    private String cityCode;

    private String formateedAddress;
}
