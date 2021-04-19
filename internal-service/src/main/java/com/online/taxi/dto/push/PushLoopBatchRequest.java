package com.online.taxi.dto.push;

import lombok.Data;

import java.util.List;

/**
 * 批量获取消息对象
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PushLoopBatchRequest {

    private Integer acceptIdentity;

    private List<String> acceptIds;

    private Integer messageType;

    private String messageBody;

    private String sendId;

    private Integer sendIdentity;

    public PushLoopBatchRequest(Integer acceptIdentity, List<String> acceptIds, Integer messageType, String messageBody, String sendId, Integer sendIdentity) {
        this.acceptIdentity = acceptIdentity;
        this.acceptIds = acceptIds;
        this.messageType = messageType;
        this.messageBody = messageBody;
        this.sendId = sendId;
        this.sendIdentity = sendIdentity;
    }

}
