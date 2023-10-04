package com.university.full.services;

import com.university.full.models.Course;
import com.university.full.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(String title, String description) {
        if (title != null && description != null) {
            return courseRepository.findByTitleAndDescription(title, description);
        } else if (title != null) {
            return courseRepository.findByTitle(title);
        } else if (description != null) {
            return courseRepository.findByDescription(description);
        } else {
            return courseRepository.findAll();
        }
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Transactional
    public void update(Long id, Course course) {
        course.setId(id);
        courseRepository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}