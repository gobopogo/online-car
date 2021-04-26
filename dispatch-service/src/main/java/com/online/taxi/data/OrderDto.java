package com.online.taxi.data;

import com.online.taxi.entity.Order;

/**
 * 订单对象
 *
 * @author dongjb
 * @date 2021/04/25
 */
public class OrderDto extends Order {
    private Integer orderId;

    private Integer updateType;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }
}
