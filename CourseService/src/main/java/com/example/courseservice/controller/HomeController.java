package com.example.courseservice.controller;


// t.me/superJavaDeveloper 20.05.2022;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.Entity;
//import java.util.UUID;
//
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public HttpEntity<?> getHomePage() {
        return ResponseEntity.ok().body("Bismillah");
    }
}
