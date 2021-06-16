package com.ynz.demo.bootmongodb.dao;

import com.ynz.demo.bootmongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
