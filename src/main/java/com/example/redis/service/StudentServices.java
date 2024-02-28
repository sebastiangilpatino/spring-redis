package com.example.redis.service;

import com.example.redis.model.Student;
import com.example.redis.model.StudentDTO;

public interface StudentServices {
    StudentDTO getStudentById(String id);
    Student saveStudent(String firstName, String lastName);
}
