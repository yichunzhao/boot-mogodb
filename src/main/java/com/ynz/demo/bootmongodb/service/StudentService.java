package com.ynz.demo.bootmongodb.service;

import com.ynz.demo.bootmongodb.dao.StudentRepository;
import com.ynz.demo.bootmongodb.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email).orElseThrow(() -> new NoSuchElementException("email is not found"));
    }

}
