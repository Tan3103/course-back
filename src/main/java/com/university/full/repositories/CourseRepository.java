package com.university.full.repositories;

import com.university.full.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitle(String title);

    List<Course> findByDescription(String author);

    List<Course> findByTitleAndDescription(String title, String description);
}
