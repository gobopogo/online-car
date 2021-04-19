package com.online.taxi.dao;

import com.online.taxi.entity.MessageShow;
import com.online.taxi.mapper.MessageShowMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 推送消息存储Dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class MessageShowDao {

    @NonNull
    private final MessageShowMapper messageShowMapper;

    public int insertSelective(MessageShow messageShow) {
        return messageShowMapper.insertSelective(messageShow);
    }
}
