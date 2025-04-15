package com.rlb.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RLBProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RLBProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public RLBProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String msg) {
        kafkaTemplate.send("rlb_output", msg);
    }
}
