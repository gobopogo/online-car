package com.online.taxi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 短信对象
 *
 * @author dongjb
 * @date 2021/04/18
 */
@Data
public class Sms {

    private Integer id;

    private String passengerPhoneNumber;

    private String smsContent;

    private Date sendTime;

    private String operator;

    private Integer sendFlag;

    private Integer sendNumber;

    private Date createTime;

}