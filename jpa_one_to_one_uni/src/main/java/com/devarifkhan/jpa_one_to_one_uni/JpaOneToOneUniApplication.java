package com.devarifkhan.jpa_one_to_one_uni;

import com.devarifkhan.jpa_one_to_one_uni.dao.AppDAO;
import com.devarifkhan.jpa_one_to_one_uni.entity.Course;
import com.devarifkhan.jpa_one_to_one_uni.entity.Instructor;
import com.devarifkhan.jpa_one_to_one_uni.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//            deleteInstructorDetail(appDAO);

//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);

//            findCoursesForInstructor(appDAO);

//            findInstructorWithCoursesJoinFetch(appDAO);
            
            
//            updateInstructor(appDAO);
            
//            updateCourse(appDAO);

//            deleteInstructor(appDAO);]
            
            deleteCourse(appDAO);
        };
        

    }

    private void deleteCourse(AppDAO appDAO) {
        int theId=10;
        // delete the course
        System.out.println("Deleting course id: "+theId);
        appDAO.deleteCourseById(theId);

        System.out.println("DONE!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId=10;
        System.out.println("Finding course id: "+theId);
        Course course= appDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating course id: "+theId);
        course.setTitle("Advanced Java");

        appDAO.update(course);

        System.out.println("DONE!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId=2;

        //find the instructor
        System.out.println("Finding instructor id: "+theId);
        Instructor instructor= appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: "+theId);
        instructor.setFirstName("Arif");

        appDAO.update(instructor);
        System.out.println("DONE!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId=3;

        System.out.println("Finding instructor id: "+theId);
        Instructor instructor= appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Instructor: "+instructor);
        System.out.println("The associated courses: "+instructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId=3;
        System.out.println("Finding Instructor id: "+theId);

        Instructor instructor=appDAO.findInstructorById(theId);
        System.out.println("Instructor: "+instructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: "+theId);

        List<Course> courses=appDAO.findCoursesByInstructorId(theId);
        instructor.setCourses(courses);
        System.out.println("The associated courses: "+instructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId=3;
        System.out.println("Finding Instructor id: "+theId);

        Instructor instructor=appDAO.findInstructorById(theId);
        System.out.println("Instructor: "+instructor);
        System.out.println("The associated courses: "+instructor.getCourses());

        System.out.println("Done!");


    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("cobra", "khan", "arifcse209@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("www://youtube.com", "programming");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving Instructor: " + instructor);
        appDAO.save(instructor);
        System.out.println("Instructor Saved: " + instructor);

        // create some courses
        Course course1=new Course("Java");
        Course course2=new Course("Python");
        Course course3=new Course("C++");

        // add courses to instructor
        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);

        System.out.println("Instructor updated: " + instructor);
        appDAO.save(instructor);
        System.out.println("Instructor with courses updated: " + instructor);

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
