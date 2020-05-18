package com.javatech.Employee.Controller;

import com.javatech.Employee.DTO.EmployeeMmDTO;
import com.javatech.Employee.GlobalExceptionHandler.EmployeeNotFound;
import com.javatech.Employee.Model.Employee;
import com.javatech.Employee.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public EmployeeMmDTO getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFound {
       Employee employee= employeeService.getEmployeeById(id);
        EmployeeMmDTO employeeMmDTO = modelMapper.map(employee, EmployeeMmDTO.class);
        return employeeMmDTO;
    }
    @PostMapping("/add")
    public  String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getallemps")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFound {
        employeeService.deleteEmployeeById(id);
    }



}
