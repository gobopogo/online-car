package com.online.taxi.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 订单响应
 *
 * @author dongjb
 * @date 2021/04/16
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Component
@Slf4j
public class OrderResponse extends AbstractResponse {
    private String massage;
    private Integer code;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 司机ID
     */
    private String drivceId;
    /**
     * 预估价格
     */
    private String price;

}
