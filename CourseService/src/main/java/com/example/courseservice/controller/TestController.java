//package com.example.courseservice.controller;
//
//
//// t.me/superJavaDeveloper 18.05.2022;
//
//import com.example.authservice.repository.UserRepository;
//import com.example.authservice.service.ApplicationUserService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import lombok.*;
////import lombok.experimental.FieldDefaults;
////
////import javax.persistence.Entity;
////import java.util.UUID;
////
////@EqualsAndHashCode(callSuper = true)
////@NoArgsConstructor
////@AllArgsConstructor
////@Data
////@FieldDefaults(level = AccessLevel.PRIVATE)
////@Entity
//@RestController
//@RequestMapping("/")
//@AllArgsConstructor
//public class TestController {
//    private final UserRepository userRepository;
//
//    @GetMapping("/")
//    public HttpEntity<?> getHomePage() {
//        return ResponseEntity.ok("Bismillah");
//    }
//
//    @GetMapping("/user")
//    public HttpEntity<?> getUsers() {
//        return ResponseEntity.ok().body(userRepository.findAll());
//    }
//
//    private final ApplicationUserService userService;
////
////    @PostMapping("/")
////    public HttpEntity<?> registerUser(@RequestBody UserDto userDto) {
////        CustomResponse registerResponse = userService.register(userDto);
////        if (registerResponse.isResult()) {
////            return ResponseEntity.badRequest().body(registerResponse.getMessage());
////        }
////        return ResponseEntity.ok(registerResponse.getMessage());
////    }
//}
