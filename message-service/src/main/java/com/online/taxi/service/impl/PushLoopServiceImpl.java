package com.online.taxi.service.impl;

import com.online.taxi.dao.PushLoopMessageDao;
import com.online.taxi.dto.push.PushLoopBatchRequest;
import com.online.taxi.dto.push.PushLoopMessageDto;
import com.online.taxi.entity.PushLoopMessage;
import com.online.taxi.service.PushLoopService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 获取消息服务
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Service
@RequiredArgsConstructor
public class PushLoopServiceImpl implements PushLoopService {

    @NonNull
    private final PushLoopMessageDao pushLoopMessageDao;


    /**
     * 插入单条消息
     */
    @Override
    public int insert(PushLoopMessage pushLoopMessage) {
        setProperties(pushLoopMessage);
        return pushLoopMessageDao.insert(pushLoopMessage);
    }

    private void setProperties(PushLoopMessage pushLoopMessage) {
        Date nowTime = new Date();
        pushLoopMessage.setCreateTime(nowTime);
        long expireTime = nowTime.getTime() + 1000 * 60;
        pushLoopMessage.setExpireTime(new Date(expireTime));
        pushLoopMessage.setReadFlag(0);
    }

    /**
     * 插入批量消息
     */
    @Override
    public void insertBatch(PushLoopBatchRequest pushLoopBatchRequest) {
        List<String> acceptIds = pushLoopBatchRequest.getAcceptIds();
        List<PushLoopMessage> item = new ArrayList<>();
        for (String acceptId : acceptIds) {
            PushLoopMessage pushLoopMessage = new PushLoopMessage();
            BeanUtils.copyProperties(pushLoopBatchRequest, pushLoopMessage);
            pushLoopMessage.setAcceptId(acceptId);
            setProperties(pushLoopMessage);
            item.add(pushLoopMessage);
        }

        pushLoopMessageDao.insertBatch(item);
    }

    @Override
    public List<PushLoopMessageDto> selectUnreadMessageListByIdentityAndAcceptId(Integer acceptIdentity, String acceptId) {

        List<PushLoopMessageDto> list = pushLoopMessageDao.selectUnreadMessageListByIdentityAndAcceptId(acceptIdentity, acceptId);
        List<Integer> ids = new ArrayList<>();
        for (PushLoopMessageDto pushLoopMessageDao :
                list) {
            ids.add(pushLoopMessageDao.getId());
        }
        if (!ids.isEmpty()) {
            pushLoopMessageDao.updateReadById(ids);
        }

        return list;
    }
}
