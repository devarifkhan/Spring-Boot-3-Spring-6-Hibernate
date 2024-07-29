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

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.NOT_FOUND);
    }

    // Add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.BAD_REQUEST);
    }
}