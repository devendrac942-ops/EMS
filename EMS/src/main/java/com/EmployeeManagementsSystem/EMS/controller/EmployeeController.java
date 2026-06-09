package com.EmployeeManagementsSystem.EMS.controller;

import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;
import com.EmployeeManagementsSystem.EMS.service.EmployeeServieceImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor

public class EmployeeController {

    private final EmployeeServieceImp employeeServieceImp;


    @GetMapping("/empid/{empId}")
    public ResponseEntity<SignUpResponse>getById(@Valid @PathVariable String empId){
        return ResponseEntity.ok(employeeServieceImp.getById(empId));
    }

    @GetMapping("/depId/{depId}")
    public ResponseEntity<List<SignUpResponse>>getByDepId(@Valid @PathVariable String depId){
        return ResponseEntity.ok(employeeServieceImp.getByDepId(depId));
    }

    @PutMapping("/empId/{empId}")
    public ResponseEntity<SignUpResponse>update(@Valid @PathVariable String empId, @RequestBody SignUpRequest request){
        return ResponseEntity.ok(employeeServieceImp.update(request, empId));
    }

    @DeleteMapping("/empId/{empId}")
    public  void delete(@PathVariable String empId){
         employeeServieceImp.delete(empId);
    }
}
