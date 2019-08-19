package com.xkw.zujuan.service.impl;

import com.xkw.zujuan.service.KafkaConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * kafka消费
 * @author wenxianlong
 * @date 2019-08-19
 */
@Component
@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

    @Override
    @KafkaListener(topics = {"seckill"})
    public void receiveMessage(String message) {
        logger.info("receiveMessage.message======" + message);
    }
}
