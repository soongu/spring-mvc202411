package com.spring.springmvc.chap2_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    // GET 요청 처리
    @GetMapping("/api/v1/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    // POST 요청 처리
    @PostMapping("/api/v1/submit")
    public String submit(@RequestParam String data) {
        return "Data received: " + data;
    }
}
