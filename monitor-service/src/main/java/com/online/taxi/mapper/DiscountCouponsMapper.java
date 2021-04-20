package com.online.taxi.mapper;

import com.online.taxi.response.DiscountCouponsResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 优惠券统计mapper
 *
 * @author dongjb
 * @date 2020/04/20
 */
@Mapper
@Service
public interface DiscountCouponsMapper {

    /**
     * 优惠券统计
     *
     * @param param 统计参数
     * @return 统计结果列表
     */
    List<DiscountCouponsResponse> discountCoupons(Map<String, Object> param);
}
