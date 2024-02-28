package com.example.redis.controller;

import com.example.redis.model.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface Controller {
    ResponseEntity<StudentDTO> getStudent(String id);
}
