package com.xkw.zujuan.service;

/**
 * kafka生产
 * @author wenxianlong
 * @date 2019-08-19
 */
public interface KafkaProducerService {

    void sendMessage(String channel, String message);
}
