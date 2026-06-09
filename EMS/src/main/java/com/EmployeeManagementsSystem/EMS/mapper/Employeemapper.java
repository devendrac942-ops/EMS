package com.EmployeeManagementsSystem.EMS.mapper;

import com.EmployeeManagementsSystem.EMS.DTO.LoginResponse;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;
import com.EmployeeManagementsSystem.EMS.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class Employeemapper {

//   public Employee toRequest(EmployeeRequest request){
//        return Employee.builder()
//                .empName(request.getEmpName())
//                .empEmail(request.getEmpEmail())
//                .empSalary(request.getEmpSalary())
//                .depId(request.getDepId())
//                .build();
//    }

    public SignUpResponse toResponse(Employee response){
        return SignUpResponse.builder()
                .empId(response.getEmpId())
                .empName(response.getEmpName())
                .empEmail(response.getEmpEmail())
                .role(response.getRole())
                .userName(response.getUserName())
                .department(response.getDepartment())
                .build();
    }

    public LoginResponse toLoginResponse(Employee response,String token){
        return LoginResponse.builder()
                .userName(response.getUserName())
                .role(response.getRole())
                .token(token)
                .message("Login SuccessFull")
                .build();
    }
}
