package com.online.taxi.dao;

import com.online.taxi.entity.SmsTemplate;
import com.online.taxi.mapper.SmsTemplateMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 短信模板dao
 *
 * @author dongjb
 * @date 2021/04/18
 */
@Repository
@RequiredArgsConstructor
public class SmsTemplateDao {

    @NonNull
    private final SmsTemplateMapper smsTemplateMapper;

    public SmsTemplate findByTemplateId(String templateId) {
        return smsTemplateMapper.selectByTemplateId(templateId);
    }
}
