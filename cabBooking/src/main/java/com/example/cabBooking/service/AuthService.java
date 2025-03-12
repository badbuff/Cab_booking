package com.example.cabBooking.service;

import com.example.cabBooking.dto.AuthRequest;
import com.example.cabBooking.dto.AuthResponse;
import com.example.cabBooking.repository.UserRepository;
import com.example.cabBooking.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
                       JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return new AuthResponse(token); // ✅ Fix: Ensure AuthResponse has a constructor with String token
    }
}
