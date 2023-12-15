package me.hyuxlee.springbootdev.service;


import lombok.RequiredArgsConstructor;
import me.hyuxlee.springbootdev.domain.RefreshToken;
import me.hyuxlee.springbootdev.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new IllegalArgumentException("Unexpected token"));
    }
}
