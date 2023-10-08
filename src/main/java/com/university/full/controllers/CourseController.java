package com.university.full.controllers;

import com.university.full.data.entity.CourseEntity;
import com.university.full.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/search")
    public List<CourseEntity> searchCourse(@RequestParam(required = false) String title,
                                           @RequestParam(required = false) String description) {
        return courseService.findAll(title, description);
    }

    @GetMapping("/{id}")
    public CourseEntity getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    public void createCourse(@RequestBody CourseEntity course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseEntity updatedCourse) {
        courseService.update(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
