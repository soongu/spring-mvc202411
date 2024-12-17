package com.spring.springmvc.chap7_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController7_2 {

    @GetMapping("/")
    public String index() {
        return "index"; // index.html 반환
    }
}
