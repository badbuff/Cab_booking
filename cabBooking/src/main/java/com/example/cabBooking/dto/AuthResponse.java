package com.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // ✅ Fix: Ensure a no-argument constructor is present
public class AuthResponse {
    private String token;
}
