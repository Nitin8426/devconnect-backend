// File: src/main/java/com/devconnect/user/controller/UserProfileController.java
package com.devconnect.user.controller;

import com.devconnect.user.dto.UserProfileDTO;
import com.devconnect.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @PostMapping
    public UserProfileDTO createUser(@RequestBody UserProfileDTO dto) {
        return service.createUser(dto);
    }

    @GetMapping("/{id}")
    public UserProfileDTO getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfileDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserProfileDTO updateUser(@PathVariable Long id, @RequestBody UserProfileDTO dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
