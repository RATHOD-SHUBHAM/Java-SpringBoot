package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    // todo: Method one - query to select by email
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")

    // todo: Method two
    // this will query as -- SELECT * FROM STUDENT WHERE EMAIL = ?
    Optional<Student> findStudentByEmail(String email);

}
