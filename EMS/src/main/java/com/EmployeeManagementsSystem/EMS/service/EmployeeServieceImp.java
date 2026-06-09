package com.EmployeeManagementsSystem.EMS.service;

import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;
import com.EmployeeManagementsSystem.EMS.entity.Department;
import com.EmployeeManagementsSystem.EMS.entity.Employee;
import com.EmployeeManagementsSystem.EMS.exception.DepartmentNotFoundException;
import com.EmployeeManagementsSystem.EMS.exception.EmployeeNotFoundException;
import com.EmployeeManagementsSystem.EMS.mapper.Employeemapper;
import com.EmployeeManagementsSystem.EMS.repository.DepartmentRepository;
import com.EmployeeManagementsSystem.EMS.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServieceImp {

    private final EmployeeRepository employeeRepository;
    private final Employeemapper empolyeemapper;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    //Learning git diff


    public SignUpResponse getById(String empId){
        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        return empolyeemapper.toResponse(emp);

    }

    public List<SignUpResponse> getByDepId(String depId){
        List<Employee> emp=employeeRepository.findByDepartment_DepId(depId);
        return emp.stream().map(empolyeemapper::toResponse)
                .toList();
    }

    public SignUpResponse update(SignUpRequest request, String empId){
        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        Department department=departmentRepository.findById(request.getDepId())
                .orElseThrow(()->new DepartmentNotFoundException("Department Not Found"));

       emp.setEmpName(request.getEmpName());
       emp.setEmpEmail(request.getEmpEmail());
       emp.setEmpSalary(request.getEmpSalary());
       emp.setPassword(passwordEncoder.encode(request.getPassword()));
        emp.setUserName(request.getUserName());
       emp.setRole(request.getRole());
       emp.setDepartment(department);

        Employee saved = employeeRepository.save(emp);
        return empolyeemapper.toResponse(saved);


    }

    public void delete(String empId){
        Employee emp=employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
         employeeRepository.delete(emp);
    }

}
