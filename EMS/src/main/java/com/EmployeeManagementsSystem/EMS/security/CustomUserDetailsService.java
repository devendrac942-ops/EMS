package com.EmployeeManagementsSystem.EMS.security;

import com.EmployeeManagementsSystem.EMS.entity.Employee;
import com.EmployeeManagementsSystem.EMS.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {


        Employee emp=employeeRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        return User.builder()
                .username(emp.getUserName())
                .password(emp.getPassword())
                .roles(emp.getRole().name())
                .build();




    }
}
