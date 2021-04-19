package com.online.taxi.constatnt;

/**
 * redis 订单名称
 *
 * @author dongjb
 * @date 2021/04/16
 */
public interface OrderRuleNames {

    /**
     * 订单规则前缀
     */
    String PREFIX = "order_rule";

    /**
     * 规则
     */
    String RULE = "rule";

    /**
     * 价格
     */
    String PRICE = "price";
}
