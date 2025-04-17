package com.rlb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RlbCoreApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(RlbCoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RlbCoreApplication.class);
        LOGGER.info("RLB CORE STARTED");

    }


}