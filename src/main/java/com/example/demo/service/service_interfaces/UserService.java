package com.example.demo.service.service_interfaces;


import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
