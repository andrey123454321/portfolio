package com.zaurtregulov.spring.springboot.springboot_rest.controller;


import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import com.zaurtregulov.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping ("/employees")//прописываем @GetMapping - так как метод будет работать только с методами get
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    @GetMapping("/employees/{id}")//передаем значение id в самой ссылке
    public Employee getEmployee(@PathVariable int id){//@PathVariable - получает переменную из ссылки
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }
    @PostMapping("/employees")//будем использовать для запроса метод Post
    public Employee addNewEmployee(@RequestBody Employee employee){//получаем Employee из тела запроса http
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted" ;
    }
}
