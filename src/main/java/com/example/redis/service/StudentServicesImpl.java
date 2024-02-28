package com.example.redis.service;

import com.example.redis.Exception.StudentNotFoundException;
import com.example.redis.model.Student;
import com.example.redis.model.StudentDTO;
import com.example.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServicesImpl implements StudentServices {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServicesImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO getStudentById(String id) {
        var student = studentRepository.getStudentsByStudentId(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found in redis"));
        return new StudentDTO(student.getLastName(), student.getFirstName());
    }

    @Override
    public Student saveStudent(String firstName, String lastName) {
        var newStudent = Student.builder()
                .studentId(String.valueOf(UUID.randomUUID()))
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return studentRepository.save(newStudent);
    }
}
