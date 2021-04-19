package com.online.taxi.mapper;

import com.online.taxi.dto.valuation.charging.TagPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 标签mapper
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Service
@Mapper
public interface TagRuleInfoMapper {
    /**
     * 查询标签
     *
     * @param param 查询标签对象
     * @return 标签计费列表
     */
    List<TagPrice> selectByPrimaryKey(Map<String, Object> param);
}
