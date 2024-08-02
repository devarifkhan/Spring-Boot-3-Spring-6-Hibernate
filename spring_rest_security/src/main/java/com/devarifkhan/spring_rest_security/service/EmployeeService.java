package com.devarifkhan.spring_rest_security.service;

import com.devarifkhan.spring_rest_security.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
