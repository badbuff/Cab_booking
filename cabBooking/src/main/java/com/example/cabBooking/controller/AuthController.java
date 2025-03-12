package com.example.cabBooking.controller;

import com.example.cabBooking.dto.AuthRequest;
import com.example.cabBooking.dto.AuthResponse;
import com.example.cabBooking.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
