package com.example.productapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String accessToken; // jwt
    private String refreshToken; // refresh
}