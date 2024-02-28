package com.example.redis.repository;

import com.example.redis.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, String> {
    Optional<Student> getStudentsByStudentId(String studentId);
}
