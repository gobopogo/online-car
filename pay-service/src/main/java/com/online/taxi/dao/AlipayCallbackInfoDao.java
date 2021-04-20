package com.online.taxi.dao;

import com.online.taxi.entity.AlipayCallbackInfo;
import com.online.taxi.mapper.AlipayCallbackInfoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 支付宝支付回调结果Dao
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Repository
@RequiredArgsConstructor
public class AlipayCallbackInfoDao {

    @NonNull
    private final AlipayCallbackInfoMapper alipayCallbackInfoMapper;

    public int insertSelective(AlipayCallbackInfo record) {
        return alipayCallbackInfoMapper.insertSelective(record);
    }
}
