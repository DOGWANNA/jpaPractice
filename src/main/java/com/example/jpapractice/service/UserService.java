package com.example.jpapractice.service;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.dto.UserResponseDto;
import com.example.jpapractice.model.User;
import com.example.jpapractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public ResponseEntity<User> createUser(UserRequestDto userRequestDto) {
        User user = userRepository.save(User.builder()
                .name(userRequestDto.getName())
                .team(userRequestDto.getTeam())
                .build());
        return ResponseEntity.ok(user);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for(User user : users){
            userResponseDtos.add(UserResponseDto.builder()
                            .name(user.getName())
                            .team(user.getTeam())
                    .build());
        }

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
