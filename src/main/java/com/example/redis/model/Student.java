package com.example.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Builder
@Data
@RedisHash(value = "Student")
public class Student {
    private String lastName;
    private String firstName;
    @Id
    private String studentId;
}
