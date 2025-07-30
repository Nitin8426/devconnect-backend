package com.devconnect.auth.service;

import com.devconnect.auth.model.User;
import com.devconnect.auth.payload.ResetRequest;
import com.devconnect.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {

    @Autowired
    private UserRepository repo;

    public void reset(ResetRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        // TODO: Add logic to send password reset email
        System.out.println("Sending reset link to " + user.getEmail());
    }
}
