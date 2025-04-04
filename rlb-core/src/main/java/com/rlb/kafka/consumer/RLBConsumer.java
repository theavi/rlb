package com.rlb.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RLBConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RLBConsumer.class);

    @KafkaListener(topics = "rlb_output", groupId = "rlbGroup")
    public void outputConsumer(String msg) {
        LOGGER.info(String.format("Messages Received -> %s", msg));
    }
}
