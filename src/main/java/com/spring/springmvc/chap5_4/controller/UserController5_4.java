package com.spring.springmvc.chap5_4.controller;

import com.spring.springmvc.chap5_4.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserController5_4 {

    @GetMapping("/api/v5-4/user")
    public UserResponseDTO getUser() {
        UserResponseDTO user = new UserResponseDTO();
        user.setId(1L);
        user.setName(null);
        user.setPassword("1234"); // JSON에 포함되지 않음
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
