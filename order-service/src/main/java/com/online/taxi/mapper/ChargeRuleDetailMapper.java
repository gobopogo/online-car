package com.online.taxi.mapper;

import com.online.taxi.entity.ChargeRuleDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 费用规则明细mapper
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Service
public interface ChargeRuleDetailMapper {
    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     *
     * @param record
     * @return
     */
    int insert(ChargeRuleDetail record);

    /**
     * 插入
     *
     * @param record
     * @return
     */
    int insertSelective(ChargeRuleDetail record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    List<ChargeRuleDetail> selectByPrimaryKey(Integer id);

    /**
     * 修改查询的数据
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChargeRuleDetail record);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ChargeRuleDetail record);
}
