package com.javatech.Employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
public class Department {

    @Id
    private String deptCd;

    private String DeptName;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> Employees;


    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getDeptName() {
        return DeptName;
    }




}
