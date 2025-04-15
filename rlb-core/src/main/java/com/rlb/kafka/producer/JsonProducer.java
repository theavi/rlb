package com.rlb.kafka.producer;

import com.rlb.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;


    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishJSOSNpPayload(User payload) {
        LOGGER.info("Event sent ->{}", payload.toString());
       //Message<User> message = MessageBuilder.withPayload(payload).setHeader(KafkaHeaders.TOPIC, "json_topic").build();
        kafkaTemplate.send("json_topic",payload.getId().toString(),payload);
    }



}
