// package: com.spring.springmvc.chap1_5.controller

package com.spring.springmvc.chap1_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/resources")
public class SimpleResourceController {

    // In-memory storage
    private final Map<Integer, String> resources = new HashMap<>();

    // Get resource by ID
    @GetMapping("/{id}")
    @ResponseBody
    public String getResource(@PathVariable int id) {
        if (resources.containsKey(id)) {
            return "Resource found: " + resources.get(id);
        }
        return "Resource not found";
    }

    // Create new resource
    @PostMapping
    @ResponseBody
    public String createResource(@RequestParam int id, @RequestParam String name) {
        if (resources.containsKey(id)) {
            return "Resource already exists with ID: " + id;
        }
        resources.put(id, name);
        return "Resource created with ID: " + id + " and name: " + name;
    }
}
