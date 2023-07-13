package com.example.jpapractice.controller;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpapractice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponseDto> findById(@RequestParam Long userId) throws Exception {
        return ResponseEntity.ok(userService.findById(userId));
    }
}
