package com.online.taxi.dao;

import com.online.taxi.entity.PushMessageRecord;
import com.online.taxi.mapper.PushMessageRecordMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 推送消息记录Dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class PushMessageRecordDao {

    @NonNull
    private final PushMessageRecordMapper pushMessageRecordMapper;

    public int insert(PushMessageRecord pushMessageRecord) {
        return pushMessageRecordMapper.insertSelective(pushMessageRecord);
    }
}
