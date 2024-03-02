package com.example.redis.controller;

import com.example.redis.model.StudentDTO;
import com.example.redis.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerImpl {
    private final StudentServices studentServices;

    @Autowired
    public ControllerImpl(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String id) {
        return new ResponseEntity<>(studentServices.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO) {
        var id = studentServices.saveStudent(studentDTO.firstName(), studentDTO.lastName()).getId();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
