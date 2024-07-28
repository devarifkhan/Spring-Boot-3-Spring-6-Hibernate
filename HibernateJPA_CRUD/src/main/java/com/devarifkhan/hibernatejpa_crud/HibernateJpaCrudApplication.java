package com.devarifkhan.hibernatejpa_crud;

import com.devarifkhan.hibernatejpa_crud.dao.StudentDAO;
import com.devarifkhan.hibernatejpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
        };
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple student objects
        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");
        Student student3 = new Student("Mike", "Johnson", "mike.johnson@example.com");

        // save the student objects
        System.out.println("Saving the students....");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        // display ids of the students
        System.out.println("Saved student 1. Generated id: " + student1.getId());
        System.out.println("Saved student 2. Generated id: " + student2.getId());
        System.out.println("Saved student 3. Generated id: " + student3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object....");
        Student student = new Student("Ariful", "Islam", "arif@hotmail.com");

        //save the student object
        System.out.println("Saving the student....");
        studentDAO.save(student);

        //display id of the student
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
