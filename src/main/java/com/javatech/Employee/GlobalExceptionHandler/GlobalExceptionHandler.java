package com.javatech.Employee.GlobalExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "from handleHttpRequestMethodNotSupported in GEH", ex.getMessage());
        return new ResponseEntity<Object>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    protected ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFound ex,WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "from handleEmployeeNotFound in GEH", ex.getMessage());
        return new ResponseEntity<Object>(customErrorDetails, HttpStatus.NOT_FOUND);
    }

}
