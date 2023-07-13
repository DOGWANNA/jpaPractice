package com.example.jpapractice.service;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.model.User;
import com.example.jpapractice.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.jpapractice.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto) {
        return userRepository.createUser(userRequestDto);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        List<User> users = userRepository.findAllUsers()
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다"));
        List<UserResponseDto> userResponseDtos =
        users.stream().map(UserResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(userResponseDtos);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("해당 유저가 존재하지 않습니다."));
        // orElseThrow >> 값이 Null일 경우 예외 발생
        return UserResponseDto.builder()
                .name(user.getName())
                .team(user.getTeam())
                .build();
    }
}
