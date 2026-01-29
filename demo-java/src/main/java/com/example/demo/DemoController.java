package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/success")
    public String success() {
        log.info("SUCCESS request processed");
        return "SUCCESS";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        log.warn("SLOW request start");
        Thread.sleep(3000); // > 2s để trigger slow trace
        log.warn("SLOW request end");
        return "SLOW";
    }

    @GetMapping("/error")
    public String error() {
        log.error("ERROR request happened");
        throw new RuntimeException("Simulated error");
    }
}
