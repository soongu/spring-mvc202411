package com.spring.springmvc.chap5_2.controller;

import com.spring.springmvc.chap5_2.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "chap5_2/form";
    }

    @PostMapping("/form")
    public String handleForm(@ModelAttribute UserForm userForm, Model model) {
        model.addAttribute("name", userForm.getName());
        model.addAttribute("email", userForm.getEmail());
        return "chap5_2/result";
    }
}
