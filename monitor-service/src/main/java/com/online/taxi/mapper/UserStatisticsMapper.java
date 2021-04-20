package com.online.taxi.mapper;

import com.online.taxi.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户统计mapper
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Mapper
@Service
public interface UserStatisticsMapper {

    /**
     * 注册用户数
     *
     * @param param 申请参数
     * @return 结果列表
     */
    List<UserResponse> selectRegUserStatistics(Map<String, Object> param);

    /**
     * 下单用户数
     *
     * @param param 申请参数
     * @return 结果列表
     */
    List<UserResponse> placeAnOrderUserNumber(Map<String, Object> param);

    /**
     * 活跃用户数
     *
     * @param param 申请参数
     * @return 结果列表
     */
    List<UserResponse> activeUserNumber(Map<String, Object> param);
}
