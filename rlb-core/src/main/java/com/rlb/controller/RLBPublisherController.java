package com.rlb.controller;

import com.rlb.payload.User;
import com.rlb.kafka.producer.JsonProducer;
import com.rlb.kafka.producer.RLBProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/rlb/v1")
public class RLBPublisherController {
    private static Logger LOGGER = LoggerFactory.getLogger(RLBPublisherController.class);

    private RLBProducer rlbProducer;

    private JsonProducer jsonProducer;

    public RLBPublisherController(RLBProducer rlbProducer, JsonProducer jsonProducer) {
        this.rlbProducer = rlbProducer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String msg) {
        LOGGER.info("Publish Message start :");
        rlbProducer.publish(msg);
        return new ResponseEntity<>("Message Publish", HttpStatus.ACCEPTED);
    }

    @PostMapping("/json/publish")
    public ResponseEntity<String> publishJSON(@RequestBody User user) {
        LOGGER.info("Publish Message start :");
        for(int i=1;i<100;i++) {
            Random random=new Random();
            user.setId(random.nextInt(1000));
            jsonProducer.publishJSOSNpPayload(user);
        }
        return new ResponseEntity<>("Message Publish", HttpStatus.ACCEPTED);
    }
}
