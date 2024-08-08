package com.devarifkhan.spring_mvc_crud.controller;

import com.devarifkhan.spring_mvc_crud.entity.Employee;
import com.devarifkhan.spring_mvc_crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //constructor innjection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    // add mapping for "/save"
    @PostMapping("/save")
    public String saveEmployee(Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    // add mapping for "/showFormForUpdate"
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    // add mapping for "/delete"
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

}
