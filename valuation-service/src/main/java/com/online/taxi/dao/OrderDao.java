package com.online.taxi.dao;

import com.online.taxi.entity.Order;
import com.online.taxi.mapper.OrderMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 订单操作DAO
 *
 * @author dongjb
 * @date 2021/04/17
 */
@Repository
@RequiredArgsConstructor
public class OrderDao {

    @NonNull
    private final OrderMapper orderMapper;

    /**
     * 根据订单ID查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public Order selectByOrderId(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

}
