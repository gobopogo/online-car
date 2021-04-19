package com.online.taxi.dto.map;


import java.util.List;

import lombok.Data;

/**
 * 坐标点
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Points {

    private Location startPoint;

    private Location endPoint;

    private List<Location> points;

    private Integer pointCount;


}