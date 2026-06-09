package com.EmployeeManagementsSystem.EMS.service;

import com.EmployeeManagementsSystem.EMS.DTO.DepartmentRequest;
import com.EmployeeManagementsSystem.EMS.DTO.DepartmentResponse;
import com.EmployeeManagementsSystem.EMS.entity.Department;
import com.EmployeeManagementsSystem.EMS.exception.DepartmentNotFoundException;
import com.EmployeeManagementsSystem.EMS.mapper.DepartmentMapper;
import com.EmployeeManagementsSystem.EMS.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;


    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        Department department= departmentMapper.toEntity(request);
         Department saved=departmentRepository.save(department);
         return departmentMapper.toRespnose(saved);
    }

    @Override
    public DepartmentResponse getById(String depId) {
        Department department=departmentRepository.findById(depId)
                .orElseThrow(()->new DepartmentNotFoundException("Department Id Not Found"));
        return departmentMapper.toRespnose(department);
    }
}
