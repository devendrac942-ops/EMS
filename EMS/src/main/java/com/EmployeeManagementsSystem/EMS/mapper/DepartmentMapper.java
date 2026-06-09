package com.EmployeeManagementsSystem.EMS.mapper;

import com.EmployeeManagementsSystem.EMS.DTO.DepartmentRequest;
import com.EmployeeManagementsSystem.EMS.DTO.DepartmentResponse;
import com.EmployeeManagementsSystem.EMS.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

public Department toEntity(DepartmentRequest request){
   return Department.builder()
           .depName(request.getDepName())
           .build();


}

public DepartmentResponse toRespnose(Department respnose){
  return DepartmentResponse.builder()
          .Dep_id(respnose.getDepId())
          .Dep_name(respnose.getDepName())
          .build();

}
}
