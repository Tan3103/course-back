package com.university.full.controllers;

import com.university.full.models.Course;
import com.university.full.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/search")
    public List<Course> searchCourse(@RequestParam(required = false) String title,
                                     @RequestParam(required = false) String description) {
        return courseService.findAll(title, description);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        courseService.update(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
