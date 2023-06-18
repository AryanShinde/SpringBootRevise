package com.springboot.msci.Model;

import jakarta.persistence.*;

@Entity

@Table(name="employees")
public class Employees {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
    @Column(name="empid")
    private int empId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="designation")
    private String designation;
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
