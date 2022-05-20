package com.example.authservice.controller;


// t.me/superJavaDeveloper 14.05.2022;

import com.example.authservice.service.ApplicationUserService;
import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ApplicationUserService userService;

    @GetMapping("{userId}")
    public HttpEntity<?> getStudent(@PathVariable String userId) {
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(userId));
        return optionalUser.isEmpty() ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(optionalUser.get());
    }

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@RequestBody UserDto userDto) {
        CustomResponse registerResponse = userService.register(userDto);
        if (registerResponse.isResult()) {
            return ResponseEntity.badRequest().body(registerResponse.getMessage());
        }
        return ResponseEntity.ok(registerResponse.getMessage());
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
             username = ((UserDetails) principal).getUsername();
        } else {
             username = principal.toString();
        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.get();

    }


}
