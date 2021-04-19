package com.online.taxi.dto;

import lombok.Data;

import java.util.Map;

/**
 * 短信模板
 *
 * @author dongjb
 * @date 2021/04/18
 */
@Data
public class SmsTemplateDto {

    private String id;

    private Map<String, Object> templateMap;

    @Override
    public String toString() {
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }

}