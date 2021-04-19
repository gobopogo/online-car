package com.online.taxi.dto.map;

import java.util.List;

import lombok.Data;

/**
 * 车辆调度对象
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class Dispatch {

    private Integer count;

    private String orderId;

    private List<Vehicle> vehicles;
}