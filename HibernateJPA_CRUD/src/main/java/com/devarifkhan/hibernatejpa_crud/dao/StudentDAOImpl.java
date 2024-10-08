package com.devarifkhan.hibernatejpa_crud.dao;


import com.devarifkhan.hibernatejpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create a query to get all students
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName asc", Student.class);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);

        // set query parameter
        theQuery.setParameter("theData", theLastName);

        // return query result

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
        // remove the student
        entityManager.remove(theStudent);




    }

    @Override
    @Transactional
    public int deleteAll() {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);

        // get the result list
        List<Student> students = theQuery.getResultList();

        // delete all students
        for (Student tempStudent : students) {
            entityManager.remove(tempStudent);
        }

        // return the number of deleted students
        return students.size();


    }
}


