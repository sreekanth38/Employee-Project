package com.javatech.Employee.Service;

import com.javatech.Employee.GlobalExceptionHandler.EmployeeNotFound;
import com.javatech.Employee.Model.Employee;
import com.javatech.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String addEmployee(Employee emp){
       /* Optional<Employee>  optionalEmployee = employeeRepository.findById(emp.getEmpId());
        if (optionalEmployee.isPresent())
            return "Employee with id: "+emp.getEmpId()+" already exist";*/
        employeeRepository.save(emp);
        return "Employee saved into the Repository";
    }

    public List<Employee> getAllEmployees(){
        List<Employee> allEmps = employeeRepository.findAll();
        return allEmps;
    }

    public Employee getEmployeeById(Long id) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFound("employee with id : "+id+" not exist");
        }
        else
            return optionalEmployee.get();

    }

    public void deleteEmployeeById(Long id) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFound("employee with id : "+id+" not exist");
        }
        else
            employeeRepository.deleteById(id);
    }
}
