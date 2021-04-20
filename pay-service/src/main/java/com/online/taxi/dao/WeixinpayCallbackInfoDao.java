package com.online.taxi.dao;

import com.online.taxi.entity.WeixinpayCallbackInfo;
import com.online.taxi.mapper.WeixinpayCallbackInfoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 微信支付回调结果Dao
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Repository
@RequiredArgsConstructor
public class WeixinpayCallbackInfoDao {

    @NonNull
    private final WeixinpayCallbackInfoMapper weixinpayCallbackInfoMapper;

    public int insertSelective(WeixinpayCallbackInfo record) {

        return weixinpayCallbackInfoMapper.insertSelective(record);
    }
}
