package com.online.taxi.dto.push;

import lombok.Data;

/**
 * 推送消息对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class JpushMessage {

    private int messageType;

    private String title;

    private String messageBody;
}