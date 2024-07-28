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
            createStudent(studentDAO);
        };
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
