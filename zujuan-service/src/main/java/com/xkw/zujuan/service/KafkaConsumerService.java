package com.xkw.zujuan.service;

/**
 * kafka消费
 * @author wenxianlong
 * @date 2019-08-19
 */
public interface KafkaConsumerService {

    void receiveMessage(String message);
}
