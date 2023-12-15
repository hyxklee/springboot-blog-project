package me.hyuxlee.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.hyuxlee.springbootdev.config.jwt.TokenProvider;
import me.hyuxlee.springbootdev.domain.User;
import me.hyuxlee.springbootdev.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken){
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
