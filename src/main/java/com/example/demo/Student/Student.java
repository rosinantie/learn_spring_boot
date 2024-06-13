package com.example.demo.Student;

import java.time.LocalDate;

public class Student {
  private Long id;
  private String name;
  private String Email;
  private LocalDate dob;
  private Integer age;

  public Student(Long id, String name, String email, LocalDate dob, Integer age) {
    this.id = id;
    this.name = name;
    Email = email;
    this.dob = dob;
    this.age = age;
  }

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
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", Email=" + Email + ", dob=" + dob + ", age=" + age + "]";
  }

}
