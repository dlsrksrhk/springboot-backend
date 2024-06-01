package me.kdh.service;

import lombok.RequiredArgsConstructor;
import me.kdh.domain.User;
import me.kdh.dto.AddUserRequest;
import me.kdh.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Long save(AddUserRequest request) {
        return userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()).getId();
    }
}