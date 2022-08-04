package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.zaurtregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with id =" + id + " in Database");
        }
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
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with id =" + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted" ;
    }
}
