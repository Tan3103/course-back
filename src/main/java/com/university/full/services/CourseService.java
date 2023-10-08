package com.university.full.services;

import com.university.full.data.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseEntity> findAll(String title, String description);

    CourseEntity findById(Long id);

    void save(CourseEntity course);

    void update(Long id, CourseEntity course);

    void deleteById(Long id);
}