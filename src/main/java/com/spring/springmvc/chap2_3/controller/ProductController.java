package com.spring.springmvc.chap2_3.controller;

import com.spring.springmvc.chap2_3.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    // 인메모리 데이터 저장소
    private final Map<Long, Product> productStore = new HashMap<>();
    private long nextId = 1L;

    // GET 요청: 상품 조회
    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable("id") Long productId) {
        Product product = productStore.get(productId);
        if (product == null) {
            return "상품 ID=" + productId + "이 존재하지 않습니다.";
        }
        return "조회된 상품: " + product;
    }

    // POST 요청: 상품 생성
    @PostMapping("/products")
    public String createProduct(@RequestParam("name") String name,
                                @RequestParam("price") double price) {
        Product newProduct = new Product(nextId, name, price);
        productStore.put(nextId, newProduct);
        nextId++;
        return "생성된 상품: " + newProduct;
    }

    // PUT 요청: 상품 수정
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long productId,
                                @RequestParam("name") String name,
                                @RequestParam("price") double price) {
        Product existingProduct = productStore.get(productId);
        if (existingProduct == null) {
            return "상품 ID=" + productId + "이 존재하지 않습니다.";
        }
        existingProduct.setName(name);
        existingProduct.setPrice(price);
        return "수정된 상품: " + existingProduct;
    }

    // DELETE 요청: 상품 삭제
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        Product removedProduct = productStore.remove(productId);
        if (removedProduct == null) {
            return "상품 ID=" + productId + "이 존재하지 않습니다.";
        }
        return "삭제된 상품: " + removedProduct;
    }
}
