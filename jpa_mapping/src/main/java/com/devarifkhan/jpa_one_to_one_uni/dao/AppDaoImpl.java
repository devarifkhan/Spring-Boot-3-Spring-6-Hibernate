package com.devarifkhan.jpa_one_to_one_uni.dao;

import com.devarifkhan.jpa_one_to_one_uni.entity.Course;
import com.devarifkhan.jpa_one_to_one_uni.entity.Instructor;
import com.devarifkhan.jpa_one_to_one_uni.entity.InstructorDetail;
import com.devarifkhan.jpa_one_to_one_uni.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        Instructor instructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }

        entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailsById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:data", Instructor.class);
        query.setParameter("data", theId);
        // execute the query
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course course = entityManager.find(Course.class, theId);

        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "where c.id=:data", Course.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " + "JOIN FETCH c.students " + "where c.id=:data", Course.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s " + "JOIN FETCH s.courses " + "where s.id=:data", Student.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student student = entityManager.find(Student.class, theId);
        entityManager.remove(student);

    }
}
