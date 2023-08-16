package com.example.jpapractice.controller;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpapractice.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
//        return userService.createUser(userRequestDto);
//    }
//
//    @GetMapping("/findall")
//    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
//        return userService.findAllUsers();
//    }
//
//    @GetMapping("/find")
//    public ResponseEntity<UserResponseDto> findById(@RequestParam Long userId) throws Exception {
//        return ResponseEntity.ok(userService.findById(userId));
//    }
}
