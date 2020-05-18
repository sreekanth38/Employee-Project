package com.javatech.Employee.GlobalExceptionHandler;

public class EmployeeNotFound extends Exception {

    public EmployeeNotFound(String message) {
        super(message);
    }
}
