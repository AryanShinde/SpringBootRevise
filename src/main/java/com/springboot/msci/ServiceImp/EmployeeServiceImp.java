package com.springboot.msci.ServiceImp;

import com.springboot.msci.Model.Employees;
import com.springboot.msci.Services.EmployeeService;
import com.springboot.msci.database.Repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employees> getAllEmployees() {
        List<Employees> allEMps =null;
        try{
            allEMps=employeeRepo.findAll();
            if(allEMps.size()!=0){
                return allEMps;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return allEMps;
    }

    @Override
    public Employees addEmployee(Employees employee) {
        Employees newEmp=null;
        try {
            newEmp = employeeRepo.save(employee);

                return newEmp;

        }catch (Exception e) {
            System.out.println(e);
            return newEmp;
        }


    }

    @Override
    public String deleteEmployee(int id) {
        try{
            employeeRepo.deleteById(id);
            return "Employee deleted successfully";
        }catch (Exception e){
            System.out.println(e);
            return "Server error";
        }
    }

    @Override
    public Employees getEmployee(int id) {
        Employees employee=null;
        try {
            employee = employeeRepo.findById(id).get();
            return employee;
        }
        catch (Exception e){
            System.out.println(e);
            return employee;
        }
    }

    @Override
    public String updateEmployee(Employees employee) {
        try{
            employeeRepo.save(employee);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Employees> getEmployeesOfDesig(String design) {
        System.out.println(design + "bruhhhhh");
        return employeeRepo.getEmployeesOfDesignation(design);
    }
}
