package com.javatech.Employee.DTO;

import com.javatech.Employee.Model.Department;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeMmDTO {

    private Long empId;

    private String empFName;

    private String empLName;

    private LocalDate DOB;

    private Character gender;

    private Department department;

}
