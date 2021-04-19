package com.online.taxi.dto.push;

import lombok.Data;

/**
 * 推送信息
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PushRequest {

    private String sendId;

    private Integer sendIdentity;

    private int acceptIdentity;

    private String acceptId;

    private int messageType;

    private String title;

    private String messageBody;

    private Integer messageChannel;

    private String businessMessage;

    private Integer businessType;

    public PushRequest() {
    }
}