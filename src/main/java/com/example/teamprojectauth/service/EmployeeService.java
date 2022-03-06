package com.example.teamprojectauth.service;

import com.example.teamprojectauth.dao.EmployeeDao;
import com.example.teamprojectauth.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateRecord(employee);
    }

}
