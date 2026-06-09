package com.EmployeeManagementsSystem.EMS.service;

import com.EmployeeManagementsSystem.EMS.DTO.LoginRequest;
import com.EmployeeManagementsSystem.EMS.DTO.LoginResponse;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;
import com.EmployeeManagementsSystem.EMS.entity.Department;
import com.EmployeeManagementsSystem.EMS.entity.Employee;
import com.EmployeeManagementsSystem.EMS.enums.Role;
import com.EmployeeManagementsSystem.EMS.exception.DepartmentNotFoundException;
import com.EmployeeManagementsSystem.EMS.exception.EmployeeNotFoundException;
import com.EmployeeManagementsSystem.EMS.mapper.Employeemapper;
import com.EmployeeManagementsSystem.EMS.repository.DepartmentRepository;
import com.EmployeeManagementsSystem.EMS.repository.EmployeeRepository;
import com.EmployeeManagementsSystem.EMS.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final Employeemapper employeemappper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


        public SignUpResponse register(SignUpRequest request){
            Department department=departmentRepository.findById(request.getDepId())
                    .orElseThrow(()->new DepartmentNotFoundException("Department Not Found"));

            Employee emp=Employee.builder()
                    .empName(request.getEmpName())
                    .empEmail(request.getEmpEmail())
                    .empSalary(request.getEmpSalary())
                    .userName(request.getUserName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .department(department)
                    .build();
            Employee saved=employeeRepository.save(emp);
            return employeemappper.toResponse(saved);
        }

        public LoginResponse login (LoginRequest request){
             authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(
                             request.getUserName(),
                             request.getPassword()
                     ));


            Employee emp = employeeRepository.findByUserName(request.getUserName())
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));

            String token=jwtService.generateToken(request.getUserName());

            return employeemappper.toLoginResponse(emp,token);
        }
}
