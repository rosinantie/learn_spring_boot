package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            // Define LocalDate objects for date of birth
            LocalDate dob1 = LocalDate.of(1990, 5, 15); // May 15, 1990
            LocalDate dob2 = LocalDate.of(1995, 8, 20); // August 20, 1995

            // Create Student objects with dob
            Student mariam = new Student(null, "Mariam", "mariam@example.com", dob1);
            Student alex = new Student(null, "Alex", "alex@example.com", dob2);

            // Save students to repository
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
