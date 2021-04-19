package com.online.taxi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 短信模板
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class SmsTemplate {
    private Integer id;

    private String templateId;

    private String content;

    private Date createTime;

    private Date updateTime;
}