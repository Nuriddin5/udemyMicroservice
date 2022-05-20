package com.example.courseservice.dataLoader;


// t.me/superJavaDeveloper 20.05.2022;

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

import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private  final CourseRepository courseRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Value("${spring.sql.init.mode}")
    String initMode;


    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {
//            List<String> ids = new ArrayList<>();
//            courseRepository.save(new Course(
//                "Java Core",100,objectMapper.;
//            ));
        }
    }
}
