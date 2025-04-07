package com.rlb.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class RLBKafkaConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RLBKafkaConfig.class);

    @Bean
    public NewTopic output() {
        return TopicBuilder.name("rlb_output").build();
    }
    @Bean
    public NewTopic input() {
        return TopicBuilder.name("rlb_input").build();
    }
    @Bean
    public NewTopic error() {
        return TopicBuilder.name("rlb_error").build();
    }
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("json_topic").build();
    }
}
