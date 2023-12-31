package com.university.full.services.impl;

import com.university.full.data.entity.EnrollmentEntity;
import com.university.full.repository.EnrollmentRepository;
import com.university.full.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public List<EnrollmentEntity> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public EnrollmentEntity findById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(EnrollmentEntity course) {
        enrollmentRepository.save(course);
    }

    @Override
    @Transactional
    public void update(Long id, EnrollmentEntity enrollment) {
        enrollment.setId(id);
        enrollmentRepository.save(enrollment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}