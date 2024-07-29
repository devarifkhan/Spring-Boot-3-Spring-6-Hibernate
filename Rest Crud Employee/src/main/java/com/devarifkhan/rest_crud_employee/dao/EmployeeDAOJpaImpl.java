package com.devarifkhan.rest_crud_employee.dao;

import com.devarifkhan.rest_crud_employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // define method to return all employees
    @Override
    public List<Employee> findAll() {
       //create a typed query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class,id);
        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee dbEmployee= entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(Integer id) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class,id);

        // remove employee
        entityManager.remove(theEmployee);




    }
}
