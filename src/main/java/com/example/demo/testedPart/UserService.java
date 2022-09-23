package com.example.demo.testedPart;


import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
