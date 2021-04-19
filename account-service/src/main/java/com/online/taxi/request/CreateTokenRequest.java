package com.online.taxi.request;

import lombok.Data;

/**
 * 创建token申请
 *
 * @author dongjb
 * @date 2018/08/15
 **/
@Data
public class CreateTokenRequest {

    private int type;

    private String phoneNum;

    private int id;
}
