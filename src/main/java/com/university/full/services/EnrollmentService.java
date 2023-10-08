package com.university.full.services;

import com.university.full.data.entity.EnrollmentEntity;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentEntity> findAll();

    EnrollmentEntity findById(Long id);

    void save(EnrollmentEntity course);

    void update(Long id, EnrollmentEntity course);

    void deleteById(Long id);
}