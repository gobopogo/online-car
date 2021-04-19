package com.online.taxi.dto.map;

import lombok.Data;

/**
 * 位置信息
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Location {

    private Long locateTime;

    private String longitude;

    private String latitude;

}