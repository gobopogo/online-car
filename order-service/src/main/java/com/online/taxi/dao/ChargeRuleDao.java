package com.online.taxi.dao;

import com.online.taxi.dto.valuation.charging.TagPrice;
import com.online.taxi.entity.ChargeRule;
import com.online.taxi.entity.ChargeRuleDetail;
import com.online.taxi.mapper.ChargeRuleDetailMapper;
import com.online.taxi.mapper.ChargeRuleMapper;
import com.online.taxi.mapper.TagRuleInfoMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 计费规则dao
 *
 * @author dongjb
 * @date 2021/04/16
 **/
@Repository
@Service
@RequiredArgsConstructor
public class ChargeRuleDao {

    @NonNull
    private final ChargeRuleMapper chargeRuleMapper;

    @NonNull
    private final ChargeRuleDetailMapper chargeRuleDetailMapper;

    @NonNull
    private final TagRuleInfoMapper tagRuleInfoMapper;

    public List<ChargeRule> selectByPrimaryKey(ChargeRule chargeRule) {
        return chargeRuleMapper.selectByPrimaryKey(chargeRule);
    }

    public List<ChargeRuleDetail> chargeRuleDetailList(Integer ruleId) {
        return chargeRuleDetailMapper.selectByPrimaryKey(ruleId);
    }

    public List<TagPrice> selectTapInfo(Map<String, Object> param) {
        return tagRuleInfoMapper.selectByPrimaryKey(param);
    }
}
