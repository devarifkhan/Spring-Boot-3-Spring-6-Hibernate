package com.devarifkhan.rest_crud_employee.dao;

import com.devarifkhan.rest_crud_employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//that's all... not need to write any code LOL!
}
