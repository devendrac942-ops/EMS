package com.EmployeeManagementsSystem.EMS.DTO;


import com.EmployeeManagementsSystem.EMS.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {


    private String userName;
    private Role role;
    private String token;
    private String message;
}
