package com.online.taxi.service.impl;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.mapper.DiscountCouponsMapper;
import com.online.taxi.request.DiscountCouponsRequest;
import com.online.taxi.response.DiscountCouponsResponse;
import com.online.taxi.service.DiscountCouponsService;
import com.online.taxi.util.GetBetweenDates;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优惠券统计服务
 *
 * @author dongjb
 * @date 2020/04/20
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountCouponsServiceImpl implements DiscountCouponsService {

    @NonNull
    private final DiscountCouponsMapper discountCouponsMapper;

    /**
     * 优惠券统计
     *
     * @param request 优惠券统计申请对象
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult<?> discountCouponsStatistics(DiscountCouponsRequest request) {
        //统计周期-天
        String periodDay = "1";
        List<DiscountCouponsResponse> discountCouponsResponses;
        Map<String, Object> param = new HashMap<>(3);
        param.put("period", request.getPeriod());
        param.put("begin", request.getBegin());
        param.put("end", request.getEnd());
        List<String> list;
        if (request.getPeriod().equals(periodDay)) {
            list = GetBetweenDates.getBetweenDate(request.getBegin(), request.getEnd());
        } else {
            list = GetBetweenDates.getMonthBetweenDate(request.getBegin(), request.getEnd());
        }
        param.put("list", list);
        discountCouponsResponses = discountCouponsMapper.discountCoupons(param);
        return ResponseResult.success(discountCouponsResponses);
    }
}
