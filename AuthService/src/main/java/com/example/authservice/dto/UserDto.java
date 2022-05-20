package com.example.authservice.dto;


// t.me/superJavaDeveloper 14.05.2022;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity


public class UserDto {


    String fullName;

    String username;

    String password;

    String checkPassword;

}
