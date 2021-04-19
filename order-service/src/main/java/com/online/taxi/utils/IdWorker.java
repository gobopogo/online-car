package com.online.taxi.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成订单ID
 *
 * @author dongjb
 * @date 2021/04/15
 **/
@Component
public class IdWorker {
    private final AtomicInteger sequence = new AtomicInteger();

    private String lastTimestamp = "";

    /**
     * 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环)，下次再使用时sequence是新值
     * @return id
     */
    public String nextId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timestamp = sdf.format(new Date());
        if (!this.lastTimestamp.equals(timestamp)) {
            sequence.set(0);
        }
        this.lastTimestamp = timestamp;
        return timestamp + fixedLenSeq();
    }


    /**
     * sequence 值
     * @return seq
     */
    public String fixedLenSeq() {
        String seq = "000" + sequence.incrementAndGet();
        int value = 4;
        if (seq.length() > value) {
            return seq.substring(seq.length() - 4, seq.length());
        }
        return seq;
    }

}
