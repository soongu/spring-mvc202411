// 1. Controller 생성
package com.spring.springmvc.chap1_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "DispatcherServlet 동작 확인");
        return "chap1_2/hello"; // View 이름 반환 (hello.jsp)
    }
}
