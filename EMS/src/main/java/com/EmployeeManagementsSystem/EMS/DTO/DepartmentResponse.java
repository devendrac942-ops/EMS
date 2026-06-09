package com.EmployeeManagementsSystem.EMS.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {

    private String Dep_id;


    private String Dep_name;
}
