package com.example.productapi.controller;

import com.example.productapi.dto.*;
import com.example.productapi.entity.User;
import com.example.productapi.repository.UserRepository;
import com.example.productapi.repository.RefreshTokenRepository;
import com.example.productapi.security.JwtUtil;
import com.example.productapi.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RefreshTokenService refreshTokenService;
    private final RefreshTokenRepository refreshTokenRepository;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String access = jwtUtil.generateToken(user.getUsername());

        String refresh = refreshTokenService.createRefreshToken(user).getToken();

        return new AuthResponse(access, refresh);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestParam String token) {

        var refreshToken = refreshTokenRepository.findByToken(token).orElseThrow();

        refreshTokenService.verifyExpiration(refreshToken);

        String access = jwtUtil.generateToken(refreshToken.getUser().getUsername());

        return new AuthResponse(access, token);
    }
}