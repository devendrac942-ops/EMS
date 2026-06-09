package com.EmployeeManagementsSystem.EMS.DTO;

import com.EmployeeManagementsSystem.EMS.entity.Department;
import com.EmployeeManagementsSystem.EMS.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponse {

    private String empId;
    private String empName;
    private String empEmail;
    private String userName;
    private Role role;
    private Department department;
}
