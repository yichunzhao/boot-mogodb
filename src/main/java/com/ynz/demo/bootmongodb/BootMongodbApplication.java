package com.ynz.demo.bootmongodb;

import com.ynz.demo.bootmongodb.dao.StudentRepository;
import com.ynz.demo.bootmongodb.domain.Address;
import com.ynz.demo.bootmongodb.domain.Gender;
import com.ynz.demo.bootmongodb.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class BootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return (args) -> {
            Address address = Address.builder().city("Cph").country("DK").postCode("1000").build();

            String email = "ynz@hotmail.com";

            Student student = Student.builder().firstName("Yichun").lastName("Zhao").email(email)
                    .gender(Gender.MALE).favoriteSubjects(List.of("Food", "Hiking", "Coding", "History"))
                    .totalSpentInBooks(BigDecimal.valueOf(5))
                    .address(address).createdAt(LocalDateTime.now())
                    .build();

            //from mongo core
            Query query = new Query();

            //creating search Criteria
            query.addCriteria(Criteria.where("email").is(email));

            List<Student> students = mongoTemplate.find(query, Student.class);

            if (students.size() >= 1) {
                log.error("The email has been used");
            } else {
                log.info("inserting student" + student.toString());
                repository.insert(student);

                log.info("+++looking for a student by his firstname");
                List<Student> foundList = repository.findStudentByFirstName("Yichun");
                log.info("--- foundList" + foundList.toString());
            }
        };
    }

}
