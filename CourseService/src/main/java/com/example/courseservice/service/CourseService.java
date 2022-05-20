package com.example.courseservice.service;


// t.me/superJavaDeveloper 20.05.2022;

import com.amigoscode.clients.auth.AuthServiceFeign;
import com.amigoscode.clients.auth.User;
import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CourseService  {
    private final CourseRepository courseRepository;
    private final AuthServiceFeign authServiceFeign;


    public boolean addCourse(Course courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setPrice(courseDto.getPrice());
        User currentUser = authServiceFeign.getCurrentUser();
        course.setInstructorsId(currentUser.getId());
        courseRepository.save(course);

        return courseRepository.existsById(course.getId());
    }
}
