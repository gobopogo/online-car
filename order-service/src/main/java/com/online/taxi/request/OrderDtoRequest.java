package com.online.taxi.request;

import com.online.taxi.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 订单申请对象
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDtoRequest extends Order {
    /**
     * 订单标识
     */
    private Integer orderId;

    /**
     * 订单价格
     */
    private String orderPrice;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 服务类型标识
     */
    private Integer serviceTypeId;

    /**
     * 服务类型名称
     */
    private String serviceTypeName;

    /**
     * 渠道标识
     */
    private Integer channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 车辆层级标识
     */
    private Integer carLevelId;

    /**
     * 车辆层级名称
     */
    private String carLevelName;

    /**
     * 用车时长
     */
    private Integer useCarTime;

    /**
     * 过路费
     */
    private BigDecimal roadPrice;

    /**
     * 停车费
     */
    private BigDecimal parkingPrice;

    /**
     * 其它费用
     */
    private BigDecimal otherPrice;

    /**
     * 当前司机
     */
    private Integer driverIdNow;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 改派类型
     */
    private Integer reasonType;

    /**
     * 改派内容
     */
    private String reasonText;

    /**
     * 订单ids
     */
    private String orderIds;

    /**
     * 更新类型
     */
    private Integer updateType;

    /**
     * 司机经度
     */
    private String driverLongitude;

    /**
     * 司机纬度
     */
    private String driverLatitude;

}
