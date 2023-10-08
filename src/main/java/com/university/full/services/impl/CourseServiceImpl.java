package com.university.full.services.impl;

import com.university.full.data.entity.CourseEntity;
import com.university.full.repository.CourseRepository;
import com.university.full.services.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseEntity> findAll(String title, String description) {
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

    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(CourseEntity course) {
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void update(Long id, CourseEntity course) {
        course.setId(id);
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}