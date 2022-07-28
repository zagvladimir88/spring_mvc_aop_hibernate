package com.zagvladimir.spring.mvc.service;

import com.zagvladimir.spring.mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(Employee employee);
}
