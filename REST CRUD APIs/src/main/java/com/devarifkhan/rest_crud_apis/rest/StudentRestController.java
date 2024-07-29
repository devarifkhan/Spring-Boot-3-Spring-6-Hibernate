package com.devarifkhan.rest_crud_apis.rest;

import com.devarifkhan.rest_crud_apis.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> theStudentList = new ArrayList<Student>();
        theStudentList.add(new Student("John", "Doe"));
        theStudentList.add(new Student("Jane", "Doe"));
        theStudentList.add(new Student("Mary", "Public"));
        return theStudentList;

    }
}
