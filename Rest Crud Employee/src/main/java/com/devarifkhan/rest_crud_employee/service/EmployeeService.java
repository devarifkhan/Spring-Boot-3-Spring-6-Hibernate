package com.devarifkhan.rest_crud_employee.service;

import com.devarifkhan.rest_crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
