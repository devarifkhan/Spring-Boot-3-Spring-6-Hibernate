package com.devarifkhan.hibernatejpa_crud;

import com.devarifkhan.hibernatejpa_crud.dao.StudentDAO;
import com.devarifkhan.hibernatejpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve a student based on the id: primary key
        int studentId = 7;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);
        // change first name to "Ariful"
        System.out.println("Updating student....");
        student.setFirstName("Ariful");
        //update the student
        studentDAO.update(student);

        //display the updated student
        System.out.println("Updated student: " + student);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Islam");
        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }


    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("creating a new student .....");
        Student student = new Student("Ariful", "Islam", "ariful@hotmail.com");

        // save the student
        System.out.println("Saving student");
        studentDAO.save(student);

        // display id of the saved student
        int theId = student.getId();
        System.out.println("Saved student. Generated id: " + theId);

        //retrieve a student based on the primary key
        System.out.println("Getting student with id: " + theId);
        student = studentDAO.findById(theId);

        // display student
        System.out.println(student);

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
