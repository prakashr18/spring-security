package com.legato.controller;

import com.legato.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Prakash Kumawat"),
            new Student(2, "Vishal Sharma"),
            new Student(3, "Naveen Kumar"),
            new Student(4, "Chandra Kanth"),
            new Student(5, "Vijay Kumar"),
            new Student(6, "Mahendar Kumawat")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student "+studentId +" does not exists"));
    }
}
