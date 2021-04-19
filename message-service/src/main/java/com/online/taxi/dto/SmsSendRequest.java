package com.online.taxi.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 发送短信请求
 *
 * @author dongjb
 * @date 2021/04/18
 */
@Data
public class SmsSendRequest {

    private String[] receivers;
    private List<SmsTemplateDto> data;

    @Override
    public String toString() {
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }

}