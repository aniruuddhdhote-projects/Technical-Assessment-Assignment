package com.example.productapi.service;

import com.example.productapi.entity.RefreshToken;
import com.example.productapi.entity.User;
import com.example.productapi.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    private final long refreshDurationMs = 7 * 24 * 60 * 60 * 1000; // 7 days

    public RefreshToken createRefreshToken(User user) {

        repository.deleteByUser(user); // rotation

        RefreshToken token = RefreshToken.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(refreshDurationMs))
                .build();

        return repository.save(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {

        if (token.getExpiryDate().isBefore(Instant.now())) {
            repository.delete(token);
            throw new RuntimeException("Refresh token expired");
        }

        return token;
    }
}