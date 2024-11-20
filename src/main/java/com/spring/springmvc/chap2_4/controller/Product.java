package com.spring.springmvc.chap2_4.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
}
