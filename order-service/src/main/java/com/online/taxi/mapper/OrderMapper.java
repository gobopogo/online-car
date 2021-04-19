package com.online.taxi.mapper;

import com.online.taxi.entity.Order;
import com.online.taxi.request.OrderDtoRequest;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单mapper
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Service
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(OrderDtoRequest record);

    int batchUpdate(Map<String, Object> map);

}
