package com.EmployeeManagementsSystem.EMS.controller;

import com.EmployeeManagementsSystem.EMS.DTO.DepartmentRequest;
import com.EmployeeManagementsSystem.EMS.DTO.DepartmentResponse;
import com.EmployeeManagementsSystem.EMS.service.DepartmentServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImp departmentServiceImp;

    @PostMapping("/create")
    public ResponseEntity<DepartmentResponse>create(@Valid @RequestBody DepartmentRequest request){
        return ResponseEntity.ok(departmentServiceImp.create(request));
    }

    @GetMapping("/id/{depId}")
    public ResponseEntity<DepartmentResponse>getById(@Valid @PathVariable String depId){
        return ResponseEntity.ok(departmentServiceImp.getById(depId));
    }

}
