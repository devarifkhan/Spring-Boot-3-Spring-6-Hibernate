package com.devarifkhan.rest_crud_apis.rest;

import com.devarifkhan.rest_crud_apis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define @PostConstruct to load the student data only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Doe"));
        theStudents.add(new Student("Mary", "Public"));
    }


    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}