package com.EmployeeManagementsSystem.EMS.repository;

import com.EmployeeManagementsSystem.EMS.entity.Department;
import com.EmployeeManagementsSystem.EMS.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee>findByDepartment_DepId(String depId);
    Optional<Employee>findByUserName(String userName);




}
