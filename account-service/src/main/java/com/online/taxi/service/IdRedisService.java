package com.online.taxi.service;

/**
 * 账户redis存取
 *
 * @author dongjb
 * @date 2021/04/14
 **/
public interface IdRedisService {

    String pull(Integer idType, Integer id);

    void push(Integer idType, Integer id, String phone, Integer expHours);
}
