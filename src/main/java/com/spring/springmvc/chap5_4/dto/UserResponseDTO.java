package com.spring.springmvc.chap5_4.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값 제외
public class UserResponseDTO {

    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("full_name")
    private String name;

    @JsonIgnore // 응답에서 제외
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime createdAt;
}
