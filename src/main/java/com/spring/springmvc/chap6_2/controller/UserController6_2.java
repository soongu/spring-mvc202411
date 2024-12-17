package com.spring.springmvc.chap6_2.controller;

import com.spring.springmvc.chap6_2.exception.CustomException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v6-2/users")
public class UserController6_2 {

    private Map<Long, String> users = new HashMap<>();

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        if (id == 0) {
            throw new CustomException("서버에서 불났어요!");
        }
        if (!users.containsKey(id)) {
            throw new IllegalArgumentException("User ID not found: " + id);
        }
        return users.get(id);
    }

    @PostMapping
    public String createUser(@RequestParam Long id, @RequestParam String name) {
        if (users.containsKey(id)) {
            throw new IllegalStateException("User ID already exists: " + id);
        }
        users.put(id, name);
        return "User created: " + name;
    }
}
