// UserController 클래스
package com.spring.springmvc.chap3_2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // 인메모리 데이터베이스로 사용할 HashMap
    private final Map<Long, User> userDatabase = new HashMap<>();
    private Long userIdCounter = 1L;

    // POST 요청: 사용자 생성
    @PostMapping
    public String createUser(@RequestBody User user) {
        user.setId(userIdCounter++);
        userDatabase.put(user.getId(), user);
        return "User created: " + user;
    }

    // GET 요청: 특정 사용자 검색
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        User user = userDatabase.get(id);
        if (user == null) {
            return "User not found with ID: " + id;
        }
        return "User found: " + user;
    }

    // GET 요청: 모든 사용자 목록 반환
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }
}
