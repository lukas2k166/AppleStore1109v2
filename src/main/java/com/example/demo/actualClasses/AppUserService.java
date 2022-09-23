//package com.example.demo.actualClasses;
//
//import com.example.demo.exception.ResourceNotFoundException;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class AppUserService implements UserDetailsService {
//
//    private final UserRepository appUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        return appUserRepository.findByUsername(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User with username: " + username + " not found"));
//    }
//
//
//}
