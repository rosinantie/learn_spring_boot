package com.example.demo.Student; // Ensure this matches your actual package structure

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;
  private String name;
  private String email;
  private LocalDate dob; // Date of birth
  @Transient
  private Integer age;

  // Default constructor
  public Student() {
  }

  public Student(Long id, String name, String email, LocalDate dob) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  // Getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  // Calculate age based on date of birth (dob)
  public Integer getAge() {
    if (dob != null) {
      LocalDate now = LocalDate.now();
      return Period.between(this.dob, now).getYears();
    } else {
      return null; // Or handle default age appropriately
    }
  }

  // toString method for debugging purposes
  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", dob=" + dob +
        '}';
  }
}
