package com.zaurtregulov.spring.mvc_hibernate_aop.deo;


import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

//используется для связи контроллера с базой данных
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
