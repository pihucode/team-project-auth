package com.example.teamprojectauth.dao;

import com.example.teamprojectauth.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee>{
    public EmployeeDao() { setClazz(Employee.class);}

    public List<Employee> getAllEmployees(){
        return getAll();
    }

    public void addEmployee(Employee employee) {
        this.getCurrentSession().save(employee);
    }

}

