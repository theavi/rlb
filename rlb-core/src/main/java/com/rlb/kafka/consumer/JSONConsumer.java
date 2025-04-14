package com.rlb.kafka.consumer;

import com.rlb.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(JSONConsumer.class);

    @KafkaListener(topics = "json_topic", groupId = "rlbGroup")
    public void JsonPayloadConsume(User payload) {
        LOGGER.info("JSON payload received ->{}", payload);
    }
}
