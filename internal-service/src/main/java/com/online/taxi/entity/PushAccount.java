package com.online.taxi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 推送账户
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PushAccount {

    private Integer id;

    private String source;

    private String jpushId;

    private String yid;

    private Integer audience;

    private Integer identityStatus;

    private Date createTime;

    private Date updateTime;

}