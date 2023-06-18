package com.springboot.msci.database.Repositories;

import com.springboot.msci.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
    @Query(value = "select * from employees where designation = :desig",nativeQuery = true)
    public List<Employees> getEmployeesOfDesignation(@Param("desig") String designation);
}
