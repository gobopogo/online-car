package com.online.taxi.dto.sms;

import lombok.Data;

/**
 * 华信短信请求
 *
 * @author dongjb
 * @date 2018/10/23
 */
@Data
public class SmsRequest {
    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 手机号
     */
    private String[] phones;

    /**
     * 替换内容
     */
    private String[] content;
}
