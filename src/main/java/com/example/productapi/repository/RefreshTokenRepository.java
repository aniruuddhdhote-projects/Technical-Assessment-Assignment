package com.example.productapi.repository;

import com.example.productapi.entity.RefreshToken;
import com.example.productapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token); // find token

    void deleteByUser(User user); // rotation
}