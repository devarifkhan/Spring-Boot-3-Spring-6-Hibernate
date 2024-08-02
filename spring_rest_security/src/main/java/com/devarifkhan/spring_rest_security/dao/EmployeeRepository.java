package com.devarifkhan.spring_rest_security.dao;

import com.devarifkhan.spring_rest_security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
