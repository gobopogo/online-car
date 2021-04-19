package com.online.taxi.response;

import lombok.Data;
import net.sf.json.JSONObject;

/**
 * 高德地图http结果
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Data
public class AmapHttpResponse {

    private int status;

    private JSONObject result;
}
