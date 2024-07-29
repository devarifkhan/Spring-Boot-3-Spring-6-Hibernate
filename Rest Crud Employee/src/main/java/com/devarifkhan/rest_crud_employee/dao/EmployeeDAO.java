package com.devarifkhan.rest_crud_employee.dao;

import com.devarifkhan.rest_crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
