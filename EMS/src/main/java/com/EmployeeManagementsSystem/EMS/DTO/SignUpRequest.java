package com.EmployeeManagementsSystem.EMS.DTO;

import com.EmployeeManagementsSystem.EMS.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {

    @NotBlank(message = "name Must Be Required")
    private String empName;

    @NotNull(message = "salary amount must be required")
    private String empSalary;

    @Email
    @NotBlank(message = "Email must be required")
    private String empEmail;

    @NotBlank(message = "Department Id Must be Required")
    private String depId;

    @NotBlank(message = "Password Must Be Required")
    private String password;

    @NotBlank(message = "Username Must Be Required")
    private String userName;

    private Role role;
}
