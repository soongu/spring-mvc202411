package com.spring.springmvc.chap8_3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v8-3")
public class FileUploadController8_3 {

    private static final String UPLOAD_DIR = "/Users/superstar/Desktop/f-uploads/";

    // 다중 파일 업로드 처리
    @PostMapping("/upload-multiple-files")
    public ResponseEntity<List<String>> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
        List<String> uploadResults = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    // 고유 이름 생성 및 저장
                    String originalFilename = file.getOriginalFilename();
                    String uniqueFilename = UUID.randomUUID() + "_" + originalFilename;

                    File directory = new File(UPLOAD_DIR);
                    if (!directory.exists()) {
                        directory.mkdirs(); // 디렉터리 생성
                    }

                    // 저장 파일 경로
                    File destination = new File(UPLOAD_DIR + uniqueFilename);

                    file.transferTo(destination); // 파일 저장

                    uploadResults.add("Uploaded: " + originalFilename + " -> " + uniqueFilename);
                } catch (IOException e) {
                    uploadResults.add("Failed: " + file.getOriginalFilename() + " (Error: " + e.getMessage() + ")");
                }
            } else {
                uploadResults.add("Skipped empty file");
            }
        }

        return ResponseEntity.ok(uploadResults);
    }
}
