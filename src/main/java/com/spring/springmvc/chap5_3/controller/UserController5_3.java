package com.spring.springmvc.chap5_3.controller;

import com.spring.springmvc.chap5_3.dto.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v5-3/users")
public class UserController5_3 {

    @PostMapping
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserRequestDTO userRequestDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok("사용자가 성공적으로 등록되었습니다: " + userRequestDTO.getName());
    }
}
