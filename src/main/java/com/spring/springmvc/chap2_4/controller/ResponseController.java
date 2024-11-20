package com.spring.springmvc.chap2_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/response")
public class ResponseController {

    // HTML 응답
    @GetMapping("/html")
    @ResponseBody
    public String htmlResponse() {
        return "<html><body><h1>Hello, Spring MVC!</h1></body></html>";
    }

    // JSON 응답
    @GetMapping("/json")
    @ResponseBody
    public Product jsonResponse() {
        return new Product(1L, "Laptop", 1200.00);
    }

    // 텍스트 응답
    @GetMapping("/text")
    @ResponseBody
    public String textResponse() {
        return "Hello, this is a plain text response!";
    }
}
