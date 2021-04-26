package com.online.taxi.request;

import lombok.Data;

/**
 * 冻结请求对象
 *
 * @author dongjb
 * @date 2021/04/20
 */
@Data
public class FreezeRequest {
    private Integer orderId;

    private Integer yid;
}
