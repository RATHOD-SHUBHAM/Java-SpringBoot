package com.example.demo.Student;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    // call the Repository here
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentInfo(){
//        return List.of(
//                // create object for student class
//                new Student(
//                        1L,
//                        "Saro",
//                        "saro.cho@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY,05),
//                        21
//                )
//        );

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with id" + studentId + "doesnot exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id"+ studentId +"doesnot exist"
        ));

        if( name!= null && name.length() > 0
            && !Objects.equals(student.getName(),name)
    ){
            student.setName(name);
        }

        if( email!= null && email.length() > 0
                && !Objects.equals(student.getEmail(),email)
    ){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }

    }
}
