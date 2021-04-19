package com.online.taxi.request;

import lombok.Data;

/**
 * 校验token
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class CheckTokenRequest {

    private String token;
}
