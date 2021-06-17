package com.ynz.demo.bootmongodb.dao;

import com.ynz.demo.bootmongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findStudentByFirstName(String firstName);

    Optional<Student> findStudentByEmail(String email);

}
