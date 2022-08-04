package com.zaurtregulov.spring.rest.deo;


import com.zaurtregulov.spring.rest.entity.Employee;

import java.util.List;

//используется для связи контроллера с базой данных
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
