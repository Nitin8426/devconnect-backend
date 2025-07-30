package com.devconnect.auth.controller;

import com.devconnect.auth.dto.*;
import com.devconnect.auth.model.User;
import com.devconnect.auth.repository.UserRepository;
import com.devconnect.auth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username taken");
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        if (user.isEmpty() || !encoder.matches(request.getPassword(), user.get().getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

        String token = jwtService.generateToken(user.get().getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
