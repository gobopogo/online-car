package com.online.taxi.service;

/**
 * 推送后消息存储
 *
 * @author dongjb
 * @date 2021/04/19
 */
public interface MessageShowService {

    /**
     * 存储消息
     * @param title 标题
     * @param content 内容
     * @param yid 推送id
     * @param acceptIdentity  推送人类别
     * @param pushType 推送类型
     */
    void saveMessageShow(String title, String content, String yid, int acceptIdentity, int pushType);
}
