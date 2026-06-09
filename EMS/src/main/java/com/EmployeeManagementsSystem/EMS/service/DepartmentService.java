package com.EmployeeManagementsSystem.EMS.service;

import com.EmployeeManagementsSystem.EMS.DTO.DepartmentRequest;
import com.EmployeeManagementsSystem.EMS.DTO.DepartmentResponse;



public interface DepartmentService {


    DepartmentResponse create(DepartmentRequest request);
    DepartmentResponse getById(String depId);
}
