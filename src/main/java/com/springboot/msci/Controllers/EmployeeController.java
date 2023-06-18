package com.springboot.msci.Controllers;

import com.springboot.msci.Model.Employees;
import com.springboot.msci.ServiceImp.EmployeeServiceImp;
import com.springboot.msci.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
EmployeeServiceImp employeeService;

    public EmployeeController(EmployeeServiceImp employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("getAllEmps")
    public List<Employees> getAllEmployees(@RequestParam(name="designation",required = false) Optional<String>  designation) {
        List<Employees> allEmps = new ArrayList<>();
        try {
            if(designation.isPresent()){
                System.out.println("herer?" + designation.get());
                allEmps=employeeService.getEmployeesOfDesig(designation.get());
            }else{
                allEmps = employeeService.getAllEmployees();
                allEmps=allEmps.stream().filter(e->e.getEmpId()%2==0).collect(Collectors.toList());
            }
            return allEmps;
        } catch (Exception e) {
            System.out.println(e);
            return allEmps;
        }
    }

    @PostMapping("createEmp")
    public String createEmp(@RequestBody Employees emp){
        try {
            Employees newEmp=employeeService.addEmployee(emp);
            if(newEmp!=null) {
                return "New Employee created successfully!";
            }
            return "some error occurred";
        }
        catch (Exception e){
            System.out.println(e);
            return "Server error";
        }
    }
}
