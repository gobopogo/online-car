package com.online.taxi.dao;

import com.online.taxi.dto.push.PushLoopMessageDto;
import com.online.taxi.entity.PushLoopMessage;
import com.online.taxi.mapper.PushLoopMessageMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 获取消息dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class PushLoopMessageDao {

    @NonNull
    private final PushLoopMessageMapper pushLoopMessageMapper;

    public int insert(PushLoopMessage pushLoopMessage) {
        return pushLoopMessageMapper.insertSelective(pushLoopMessage);
    }

    public void insertBatch(List<PushLoopMessage> pushLoopMessageList) {
        pushLoopMessageMapper.insertBatch(pushLoopMessageList);
    }

    public List<PushLoopMessageDto> selectUnreadMessageListByIdentityAndAcceptId(Integer acceptIdentity, String acceptId) {
        PushLoopMessage pushLoopMessage = new PushLoopMessage();
        pushLoopMessage.setAcceptId(acceptId);
        pushLoopMessage.setAcceptIdentity(acceptIdentity);
        return pushLoopMessageMapper.selectUnreadMessageListByIdentityAndAcceptId(pushLoopMessage);
    }

    public void updateReadById(List<Integer> ids) {
        pushLoopMessageMapper.updateReadById(ids);
    }

}
