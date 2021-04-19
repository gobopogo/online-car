package com.online.taxi.dto;

import lombok.Data;

/**
 * 推送平台验证信息
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class JpushInfo {

    private String appKey;

    private String masterSecret;
}
