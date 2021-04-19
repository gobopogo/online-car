package com.online.taxi.dao;

import com.online.taxi.entity.PushAccount;
import com.online.taxi.mapper.PushAccountMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 推送账户Dao
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Repository
@RequiredArgsConstructor
public class PushAccountDao {

    @NonNull
    private final PushAccountMapper pushAccountMapper;

    public List<PushAccount> selectByIdentityAndYid(Integer identityStatus, String yid) {
        PushAccount pushAccount = new PushAccount();
        pushAccount.setIdentityStatus(identityStatus);
        pushAccount.setYid(yid);
        return pushAccountMapper.selectByIdentityAndYid(pushAccount);
    }
}
