package com.online.taxi.service.impl;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.mapper.UserStatisticsMapper;
import com.online.taxi.request.UserRequest;
import com.online.taxi.response.UserResponse;
import com.online.taxi.service.UserStatisticsService;
import com.online.taxi.util.GetBetweenDates;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户统计
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserStatisticsServiceImpl implements UserStatisticsService {

    @NonNull
    private final UserStatisticsMapper userStatisticsMapper;

    /**
     * @param request 统计申请
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult<?> userStatistics(UserRequest request) {
        //注册用户
        String regUser = "1";
        //下单用户
        String placeAnOrder= "2";
        //统计周期-天
        String periodDay = "1";

        List<UserResponse> userResponse;
        Map<String, Object> param = new HashMap<>(6);
        param.put("period", request.getPeriod());
        param.put("equipment", request.getEquipment());
        param.put("check", request.getCheck());
        param.put("begin", request.getBegin());
        param.put("end", request.getEnd());
        List<String> list;
        if (request.getPeriod().equals(periodDay)) {
            list = GetBetweenDates.getBetweenDate(request.getBegin(), request.getEnd());
        } else {
            list = GetBetweenDates.getMonthBetweenDate(request.getBegin(), request.getEnd());
        }
        param.put("list", list);

        if (regUser.equals(request.getCheck())) {
            userResponse = userStatisticsMapper.selectRegUserStatistics(param);
        } else if (placeAnOrder.equals(request.getCheck())) {
            userResponse = userStatisticsMapper.placeAnOrderUserNumber(param);
        } else {
            userResponse = userStatisticsMapper.activeUserNumber(param);
        }
        return ResponseResult.success(userResponse);
    }
}
