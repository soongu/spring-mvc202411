package com.spring.springmvc.chap4_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ThymeleafExampleController {

    @GetMapping("/api/v4-2/users")
    public String showUsers(@RequestParam(defaultValue = "Guest") String name, Model model) {
        List<String> users = List.of("Alice", "Bob", "Charlie", "Daisy");
        model.addAttribute("name", name);
        model.addAttribute("users", users);
        return "chap4_2/users";
    }
}