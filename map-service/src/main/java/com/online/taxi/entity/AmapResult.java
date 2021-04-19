package com.online.taxi.entity;

import lombok.Data;

/**
 * 高德地图返回
 *
 * @param <T>
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class AmapResult<T> {

    private int status;

    private T data;


}
