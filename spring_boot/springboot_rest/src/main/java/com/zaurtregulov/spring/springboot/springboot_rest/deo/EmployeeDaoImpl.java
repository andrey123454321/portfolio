package com.zaurtregulov.spring.springboot.springboot_rest.deo;



import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;//EntityManager - обертка сесии

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);//сохраняем объект в базу данных или изменяем существующий. Если id не ноль, то изменяет
        Employee newEmployee = entityManager.merge(employee);//добавляет или изменяет работника
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " +//создаем запрос в базу данных
//                "where id =:employeeId" );
//        query.setParameter("employeeId", id);//производим замену названия параметра на значение параметра
//        query.executeUpdate();//вызываем срабатывание метода
        Query query = entityManager.createQuery("delete from Employee " + "where id =:employeeId" );
        query.setParameter("employeeId", id);//заполгяем поле employeeId значением id
        query.executeUpdate();//выполнение запроса

    }
}
