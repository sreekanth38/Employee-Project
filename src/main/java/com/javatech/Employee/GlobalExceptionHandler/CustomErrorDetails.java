package com.javatech.Employee.GlobalExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

//create Simple custom error details bean
@AllArgsConstructor
@Getter
public class CustomErrorDetails {

	private Date timestamp;

	private String message;

	private String errordetails;

}
