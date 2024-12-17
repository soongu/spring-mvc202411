package com.spring.springmvc.chap5_3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(min = 2, max = 30, message = "이름은 2자 이상, 30자 이하로 입력하세요.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email;

    @Min(value = 1, message = "나이는 1 이상이어야 합니다.")
    private int age;
}
