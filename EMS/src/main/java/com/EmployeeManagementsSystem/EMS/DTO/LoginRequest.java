package com.EmployeeManagementsSystem.EMS.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    @NotBlank(message = "Username Must Be Required")
    private String userName;

    @NotBlank(message = "Password Must Be Required")
    private String password;
}
