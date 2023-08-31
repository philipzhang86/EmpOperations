package com.curpatient.empoperations.controller;

import com.curpatient.empoperations.dto.LoginRequest;
import com.curpatient.empoperations.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")//loginUrl = http://localhost:8081/api/login
public class AuthenticationController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        if (!new BCryptPasswordEncoder().matches(loginRequest.getPassword(), userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        return ResponseEntity.ok(response);
    }

}
