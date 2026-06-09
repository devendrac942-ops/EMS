package com.EmployeeManagementsSystem.EMS.controller;

import com.EmployeeManagementsSystem.EMS.DTO.LoginRequest;
import com.EmployeeManagementsSystem.EMS.DTO.LoginResponse;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpRequest;
import com.EmployeeManagementsSystem.EMS.DTO.SignUpResponse;
import com.EmployeeManagementsSystem.EMS.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<SignUpResponse>create(@Valid @RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse>login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
