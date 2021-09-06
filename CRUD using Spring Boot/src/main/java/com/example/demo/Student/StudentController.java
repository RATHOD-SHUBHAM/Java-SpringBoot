package com.example.demo.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// @RestController annotation was created in order to simplify the creation of RESTful web services
@RestController
@RequestMapping(path = "api/tutorial/student")
public class StudentController {

    private final StudentService StudentService;

    @Autowired
    public StudentController(com.example.demo.Student.StudentService studentService) {
        StudentService = studentService;
    }

    //todo: Get -- expose end point which return array of student
    @GetMapping
    public List<Student> getStudentInfo(){
        return StudentService.getStudentInfo();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        StudentService.addNewStudent(student);
    }

    @DeleteMapping(path= "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        StudentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        StudentService.updateStudent(studentId,name,email);
    }
}
