package com.EmployeeManagementsSystem.EMS.entity;

import com.EmployeeManagementsSystem.EMS.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String empId;
    private String empName;
    private String empSalary;
    private String empEmail;
    private String userName;
    private String password;
    private Role role;


    @DBRef
    private Department department;

}
