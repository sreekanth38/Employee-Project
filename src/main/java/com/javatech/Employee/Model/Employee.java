package com.javatech.Employee.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long empId;

    @Column(nullable = false)
    @NotNull(message = "please provide FirstName")
    private String empFName;

    @Column(nullable = false)
    @NotNull(message = "please provide LastName")
    private String empLName;

    @Column(nullable = false)
    @NotNull(message = "please provide DOB")
    private LocalDate DOB;

    @Column(nullable = false)
    @NotNull(message = "please provide gender")
    private Character gender;

    @ManyToOne()
    private Department department;

}
