package com.spring.springmvc.chap3_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3-3/users")
public class UserController3_3 {

    private final Map<Long, String> users = new HashMap<>();
    private long userIdSequence = 1;

    // 사용자 생성 (POST 요청)
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody String username) {
        if (username == null || username.isBlank()) {
//            return new ResponseEntity<>("사용자 이름은 필수입니다.", HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body("사용자 이름은 필수입니다.");
        }
        users.put(userIdSequence++, username);
//        return new ResponseEntity<>("사용자가 생성되었습니다.", HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body("사용자가 생성되었습니다.");
    }

    // 사용자 목록 조회 (GET 요청)
    @GetMapping
    public ResponseEntity<List<String>> getUsers() {
        return new ResponseEntity<>(new ArrayList<>(users.values()), HttpStatus.OK);
    }

    // 사용자 조회 (GET 요청 - ID 기반)
    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Long id) {
        String username = users.get(id);
        if (username == null) {
//            return new ResponseEntity<>("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
        }
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    // 사용자 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (users.remove(id) == null) {
            return new ResponseEntity<>("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("사용자가 삭제되었습니다.", HttpStatus.OK);
    }
}
