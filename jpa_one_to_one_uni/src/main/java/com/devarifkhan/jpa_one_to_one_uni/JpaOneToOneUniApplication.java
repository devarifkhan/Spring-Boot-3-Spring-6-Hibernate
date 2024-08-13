package com.devarifkhan.jpa_one_to_one_uni;

import com.devarifkhan.jpa_one_to_one_uni.dao.AppDAO;
import com.devarifkhan.jpa_one_to_one_uni.entity.Instructor;
import com.devarifkhan.jpa_one_to_one_uni.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOneToOneUniApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneUniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);

//            findInstructorDetail(appDAO);

            deleteInstructorDetail(appDAO);
        };

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting Instructor Detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Instructor Detail deleted with id: " + theId);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get the instructor detail object
        int theId=2;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailsById(theId);

        // print the instructor detail
        System.out.println("Instructor Detail: " + instructorDetail);
        System.out.println("The associated instructor: " + instructorDetail.getInstructor());

    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting Instructor id: " + theId);

        appDAO.deleteInstructorById(theId);
        System.out.println("Instructor deleted with id: " + theId);
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding Instructor id: " + theId);

        Instructor instructor = appDAO.findInstructorById(theId);

        System.out.println("FoundInstructor" + instructor);
        System.out.println("The associate instructorDetail only: " + instructor);
    }

    private void createInstructor(AppDAO appDAO) {
//        Instructor instructor = new Instructor("Devarif", "Khan", "arifcse209@gmail.com");
//
//        //create Instructor Details
//
//        InstructorDetail instructorDetail = new InstructorDetail("www://youtube.com", "coding");

        Instructor instructor = new Instructor("cobra", "khan", "arifcse209@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("www://youtube.com", "programming");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving Instructor: " + instructor);
        appDAO.save(instructor);
        System.out.println("Instructor Saved: " + instructor);
    }


}
