package com.EmployeeManagementsSystem.EMS.service;

import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;

import java.util.List;

public interface EmployeeService {

    SignUpResponse create(SignUpRequest request);

    SignUpResponse getById(String empId);

    List<SignUpResponse> getByDepId(String depId);

    SignUpResponse update(SignUpRequest request, String empId);

    SignUpResponse delete(String empId);

//    Optional<Department> findById( String depId);
}
