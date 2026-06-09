package com.EmployeeManagementsSystem.EMS.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentRequest {

    @NotBlank(message = "Department Name Must Be Required")
    private String depName;
}
