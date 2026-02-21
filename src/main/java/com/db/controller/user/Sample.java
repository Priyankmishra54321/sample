package com.db.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Sample {

    private static final Logger log = LoggerFactory.getLogger(Sample.class);

    @GetMapping("/api/v1/sample")
    public ResponseEntity<Object> sampleMethod() {
        List list= Arrays.asList("sample1","sample2","sample3");
        log.info("Sample list created with size: {}", list.size());
        return ResponseEntity.ok(list);
    }
}
