package com.rlb.controller;

import com.rlb.producer.RLBProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rlb/v1")
public class RLBPublisherController {
    private static Logger LOGGER = LoggerFactory.getLogger(RLBPublisherController.class);
    private RLBProducer rlbProducer;

    public RLBPublisherController(RLBProducer rlbProducer) {
        this.rlbProducer = rlbProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String msg) {
        LOGGER.info("Publish Message start :");
        rlbProducer.publish(msg);
        return new ResponseEntity<>("Message Publish", HttpStatus.ACCEPTED);
    }
}
