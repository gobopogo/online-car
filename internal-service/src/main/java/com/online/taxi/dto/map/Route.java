package com.online.taxi.dto.map;

import lombok.Data;

/**
 * 路径信息
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Route {

    /**
     * 行驶距离（米）
     */
    private Double distance;

    /**
     * 行驶时间（秒）
     */
    private Double duration;
}
