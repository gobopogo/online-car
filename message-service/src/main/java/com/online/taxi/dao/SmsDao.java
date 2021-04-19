package com.online.taxi.dao;

import com.online.taxi.entity.Sms;
import com.online.taxi.mapper.SmsMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 短信dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class SmsDao {

    @NonNull
    private final SmsMapper smsMapper;

    public int insert(Sms sms) {
        return smsMapper.insertSelective(sms);
    }
}
