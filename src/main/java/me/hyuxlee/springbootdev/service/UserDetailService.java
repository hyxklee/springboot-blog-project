package me.hyuxlee.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.hyuxlee.springbootdev.domain.User;
import me.hyuxlee.springbootdev.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException(email));
    }
}
