- spring boot starter project

# [https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.0&packaging=jar&jvmVersion=21&groupId=com.example&artifactId=demo&name=demo&description=Demo project for Spring Boot&packageName=com.example.demo&dependencies=web,data-jpa,h2,mysql](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.0&packaging=jar&jvmVersion=21&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,data-jpa,h2,mysql)

- pom.xml

this is where all the dependencies lies

- src/resource/application.properties

this is where all the config should be there

- simple restapi

main/java/com/example/demo/DemoApplication.java

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

}

```

- if you change this and save the file , you cannot able to see the value that your

for this you need to add spring-boot-devtools

STEP 1

add the spring-boot-devtools to the pom.xml file as a dependency

pom.xml

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

STEP 2

then in the resources add spring.devtools.restart.enabled=true

```
spring.application.name=demo
spring.devtools.restart.enabled=true

```

- simple way of creating a constructor go to source in right click then choice what ever you need

- java code formatter

```json
 "[java]": {
    "editor.defaultFormatter": "redhat.java"
  },
```

# THINGS TO FOLLOW IN JAVA SPRING BOOT

- use controller to control the apis or( api lawyers)
-

```
+---------------------+
|      API Layer      |
+----------+----------+
|
| HTTP / RPC
|
+----------v----------+
|    Service Layer    |
+----------+----------+
|
| Business Logic
|
+----------v----------+
|  Data Access Layer  |
+---------------------+
```

---

# JAVA SPRINGBOOT STRUCTURE

```
+---------------------+
|      API Layer      |
+----------+----------+
|
| HTTP / RPC
|
+----------v----------+
|    Service Layer    |
+----------+----------+
|
| Business Logic
|
+----------v----------+
|  Data Access Layer  |
+---------------------+
```

student.java

```java
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

```

StudentController.java

```java
package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/api/v1/students")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }
}

```

StudentServices.java

```java
package com.example.demo.Student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServices {
    public List<Student> getStudents() {
        Student student = new Student(1L, "Dilip", "dilip@mail.com", LocalDate.of(2018, 11, 1), 24);
        return List.of(student);
    }
}

```

OUTPUT

END point → http://localhost:8080/api/v1/students

response ->

```json
[
  {
    "id": 1,
    "name": "Dilip",
    "dob": "2018-11-01",
    "age": 24,
    "email": "dilip@mail.com"
  }
]
```

---

# DEPENDENCY INJECTION

this is what the dependency injection look like we used i here

```java
package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/api/v1/students")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }
}

```

---

# CONNECT WITH DATABASE

templates/application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```

---

# JPA AND @ENTITY

man dependency to use to connect and make actions with database

```xml
			<artifactId>spring-boot-starter-data-jpa</artifactId>

```

---

# JPA IN ACTION

using class we can able to create a database init

resources/application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

we must add the jpa and the properties , hibernate , show

in the spring then only we can able to create a table using the

@annonations

```java
package com.example.demo.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "students") // Specify the table name if different from the entity name
public class Student {

  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;
  private String email;
  private LocalDate dob;
  private Integer age;

  // Default constructor
  public Student() {
  }

  public Student(Long id, String name, String email, LocalDate dob, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.age = age;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  // toString method for debugging purposes
  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", dob=" + dob +
        ", age=" + age +
        '}';
  }
}

```

terminal command to view the database

mysql -u _user_name_ -p

SHOW DATABASES;

USE student;

DESCRIBE Student;

---

# JPA REPOSITORY

create a file that has only have the jpa logics

basic setup to connect the database

Student/StudentServices.java

```java
package com.example.demo.Student;

import java.util.List; // Correct import for List
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}

```

when your refresh the code you can the empty array

---

# SAVINGs STUDENTS

Students/StudentConfig.java

```java
package com.example.demo.Student;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(null, "maiarma", null, null, null);
            Student alex = new Student(null, "alex", null, null, null);

            repository.saveAll(List.of(mariam, alex));
        };
    }
}

```

this is use to create. a values into the database using the Hibernate

you can able to see in the terminal in this message

```java
Hibernate: select next_val as id_val from student_sequence for update
Hibernate: update student_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from student_sequence for update
Hibernate: update student_sequence set next_val= ? where next_val=?
Hibernate: insert into student (email,age,dob,name,id) values (?,?,?,?,?)
Hibernate: insert into student (email,age,dob,name,id) values (?,?,?,?,?)
```

---

# **transient**

```java
package com.example.demo.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDate;

@Entity
@Table(name = "students") // Specify the table name if different from the entity name
public class Student {

  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;
  private String email;
  private LocalDate dob;

  @Transient
  private Integer age;

  // Default constructor
  public Student() {
  }

  public Student(Long id, String name, String email, LocalDate dob, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.age = age;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  // toString method for debugging purposes
  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", dob=" + dob +
        ", age=" + age +
        '}';
  }
}

```

you can see that i use the transient in the age

@Transient
private Integer age;

if i run with the @Transient

```java
package com.example.demo.Student;

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
@Table(name = "students") // Specify the table name if different from the entity name
public class Student {

  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;
  private String email;
  private LocalDate dob;

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

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
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

```

the terminal output like

it doesn’t create a column of age

terminal

```java
Hibernate: insert into students (dob,email,name,id) values (?,?,?,?)
Hibernate: insert into students (dob,email,name,id) values (?,?,?,?)
```

when you applied the getAge Method to calculate the age

you can able to see the response in the json

json. response

```json
[
  {
    "id": 51,
    "name": "Mariam",
    "email": "mariam@example.com",
    "dob": "1990-05-15",
    "age": 34
  },
  {
    "id": 52,
    "name": "Alex",
    "email": "alex@example.com",
    "dob": "1995-08-20",
    "age": 28
  }
]
```

---

# POST MAPPING

StudentController.java

```java
package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentServices.addNewStudent(student);
    }
}

```

StudentServices.java

```java
package com.example.demo.Student;

import java.util.List; // Correct import for List
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }

}

```

hit the postman with this data to post

localhost:8080

```json
{
  "name": "Mariam45555",
  "email": "mariam@example.com55555",
  "dob": "1990-05-15"
}
```

---

# WRITING BUSINESS LOGIC

- set

application.properties

**server.error.include-message=always**

---

# DELETING STUDENT

create a controller for delete

student/StudentController.java

```java
  @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentServices.deleteStudent(id);
    }
```

service to delete the data

student/StudentServices.java

```java
 public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with the id" + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);

    }
```

---

# PUT THE DATA

Student/StudentController.java

```java
   @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentServices.updateStudent(studentId, name, email);
    }
```

student/studentServices.java

```java
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
```

---

# TESTING
