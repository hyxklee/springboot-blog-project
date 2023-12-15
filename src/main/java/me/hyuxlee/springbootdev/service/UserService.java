package me.hyuxlee.springbootdev.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.hyuxlee.springbootdev.domain.User;
import me.hyuxlee.springbootdev.dto.AddUserRequest;
import me.hyuxlee.springbootdev.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("Unexpected user"));
    }
}
