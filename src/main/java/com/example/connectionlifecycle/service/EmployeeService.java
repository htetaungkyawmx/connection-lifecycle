package com.example.connectionlifecycle.service;

import com.example.connectionlifecycle.dao.EmployeeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Transactional
    public void withTransaction(){
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
    }

    public void withoutTransaction(){
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
        System.out.println("Count:"+ employeeDao.countEmployee());
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


}
