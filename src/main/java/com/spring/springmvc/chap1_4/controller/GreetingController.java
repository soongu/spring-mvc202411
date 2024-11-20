// Controller 클래스
package com.spring.springmvc.chap1_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("userName", name);
        return "chap1_4/greeting"; // View 이름 반환
    }
}
