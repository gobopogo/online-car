package com.online.taxi.service;

import com.online.taxi.dto.push.PushLoopBatchRequest;
import com.online.taxi.dto.push.PushLoopMessageDto;
import com.online.taxi.entity.PushLoopMessage;

import java.util.List;

/**
 * 获取消息服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface PushLoopService {

    /**
     * 插入单条消息
     *
     * @param pushLoopMessage 消息对象
     * @return 是否成功
     */
    int insert(PushLoopMessage pushLoopMessage);

    /**
     * 插入批量消息
     *
     * @param pushLoopBatchRequest 批量消息对象
     */
    void insertBatch(PushLoopBatchRequest pushLoopBatchRequest);

    /**
     * 根据接受者身份，接受者Id查询消息
     *
     * @param acceptIdentity  接受者身份
     * @param acceptId  接受者Id
     * @return 是否成功
     */
    List<PushLoopMessageDto> selectUnreadMessageListByIdentityAndAcceptId(Integer acceptIdentity, String acceptId);
}
