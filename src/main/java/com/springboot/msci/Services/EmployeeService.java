package com.springboot.msci.Services;

import com.springboot.msci.Model.Employees;

import java.util.List;

public interface EmployeeService {
    public List<Employees> getAllEmployees();

    public Employees addEmployee(Employees employees);
    public String deleteEmployee(int id);
    public Employees getEmployee(int id);
    public String updateEmployee(Employees employee);
    public List<Employees> getEmployeesOfDesig(String design);

}
