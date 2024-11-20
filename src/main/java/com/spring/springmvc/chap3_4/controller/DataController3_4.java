// 2. RESTful API 컨트롤러
package com.spring.springmvc.chap3_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController3_4 {

    @GetMapping("/api/v3-4/data")
    public String getData() {
        return "CORS 설정이 성공적으로 적용되었습니다!";
    }
}
