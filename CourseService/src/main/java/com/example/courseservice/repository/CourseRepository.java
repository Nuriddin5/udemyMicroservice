package com.example.courseservice.repository;


// t.me/superJavaDeveloper 20.05.2022;



import com.example.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByIdAndNameAndAvgRatingAndPrice(Long id, String name, Float avgRating, Double price);
}
