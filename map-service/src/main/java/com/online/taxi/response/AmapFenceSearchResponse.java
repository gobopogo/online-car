package com.online.taxi.response;

import java.util.List;

import com.online.taxi.entity.FenceEntity;
import lombok.Data;

/**
 * 高德围栏搜索结果
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class AmapFenceSearchResponse {

    private List<FenceEntity> list;
    private int count;

    public AmapFenceSearchResponse(List<FenceEntity> list, int count) {
        this.list = list;
        this.count = count;
    }

    public AmapFenceSearchResponse() {

    }

}
