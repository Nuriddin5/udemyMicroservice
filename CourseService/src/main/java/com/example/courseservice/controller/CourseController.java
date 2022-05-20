package com.example.courseservice.controller;


// t.me/superJavaDeveloper 14.05.2022;


import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/course")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;
//    private final ApplicationUserService userService;

    @GetMapping
    public HttpEntity<?> getCoursesForMain() {
        return ResponseEntity.ok(courseRepository.findAll());
    }
    @GetMapping("/{courseId}")
    public HttpEntity<?> getCourse(@PathVariable Long courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()) {
            return ResponseEntity.badRequest().body("Course not found");
        }
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @PostMapping
    public HttpEntity<?> addCourse(@RequestBody Course courseDto) {
        boolean courseExist = courseService.addCourse(courseDto);
        if (!courseExist) {
            return ResponseEntity.badRequest().body("course not added");
        }
        return ResponseEntity.ok().body("Course added");



    }



}
