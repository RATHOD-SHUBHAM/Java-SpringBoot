package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student saro = new Student(
//                        1L, // this will be generated automatically
                        "Saro",
                        "saro.cho@gmail.com",
                        LocalDate.of(2000, Month.JANUARY,05)
                );
            Student aro = new Student(
//                        1L, // this will be generated automatically
                    "aro",
                    "aro.ho@gmail.com",
                    LocalDate.of(2004, Month.JANUARY,05)
            );

            // invoke repository and add this to database
            repository.saveAll(
                    List.of(saro,aro)
            );
        };
    }
}
