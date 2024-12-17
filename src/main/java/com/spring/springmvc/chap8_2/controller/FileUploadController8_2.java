package com.spring.springmvc.chap8_2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v8-2")
public class FileUploadController8_2 {

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("업로드할 파일이 없습니다.");
        }

        // 고유한 파일 이름 생성
        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;

        // 파일 저장 경로 설정
        String uploadDir = "/Users/superstar/Desktop/f-uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 디렉터리 생성
        }

        // 저장 파일 경로
        File destination = new File(uploadDir + uniqueFileName);

        try {
            file.transferTo(destination); // 파일 저장
            return ResponseEntity.ok("파일 업로드 성공: 이름 = " + uniqueFileName + ", 경로 = " + destination.getAbsolutePath());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("파일 저장 실패: " + e.getMessage());
        }
    }
}
