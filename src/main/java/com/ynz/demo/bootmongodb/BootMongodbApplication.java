package com.ynz.demo.bootmongodb;

import com.ynz.demo.bootmongodb.dao.StudentRepository;
import com.ynz.demo.bootmongodb.domain.Address;
import com.ynz.demo.bootmongodb.domain.Gender;
import com.ynz.demo.bootmongodb.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return (args) -> {
            Address address = Address.builder().city("Cph").country("DK").postCode("1000").build();

            Student student = Student.builder().firstName("Yichun").lastName("Zhao").email("ynz@hotmail.com")
                    .gender(Gender.MALE).favoriteSubjects(List.of("Food", "Hiking", "Coding", "History"))
                    .totalSpentInBooks(BigDecimal.valueOf(5))
                    .address(address).createdAt(LocalDateTime.now())
                    .build();

            repository.insert(student);

        };
    }

}
