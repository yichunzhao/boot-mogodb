package com.ynz.demo.bootmongodb.controller;


import com.ynz.demo.bootmongodb.domain.Student;
import com.ynz.demo.bootmongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("students/{email}")
    ResponseEntity<Student> getStudentByEmail(String email) {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

}
