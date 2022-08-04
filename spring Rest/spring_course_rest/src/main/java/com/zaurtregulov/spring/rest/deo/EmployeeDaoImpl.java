package com.zaurtregulov.spring.rest.deo;


import com.zaurtregulov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;//создаем зависимость EmployeeDaoImpl от бина sessionFactory

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();//создаем текущую сессию
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);//сохраняем объект в базу данных или изменяем существующий. Если id не ноль, то изменяет
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee " +//создаем запрос в базу данных
                "where id =:employeeId" );
        query.setParameter("employeeId", id);//производим замену названия параметра на значение параметра
        query.executeUpdate();//вызываем срабатывание метода
    }
}
