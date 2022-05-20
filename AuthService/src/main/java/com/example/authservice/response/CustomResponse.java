package com.example.authservice.response;


// t.me/superJavaDeveloper 18.05.2022;

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

public class CustomResponse {
    boolean result;

    String message;
}
