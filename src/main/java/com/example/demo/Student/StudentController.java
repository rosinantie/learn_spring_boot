package com.example.demo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/api/v1/students")
    public List<Student> StudentsList() {
        Student student = new Student(1L, "Dilip", "dilip@mail.com", LocalDate.of(2018, 11, 1), 24);
        return List.of(student);
    }

}
