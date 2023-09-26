package com.example.jpapractice.controller;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.dto.UserResponseDto;
import com.example.jpapractice.model.User;
import com.example.jpapractice.service.UserService;
import com.example.jpapractice.utils.ApachePoiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final ApachePoiUtil apachePoiUtil;

    @PostMapping("/poi")
    public void createExcelFileAndEncrypt(){
        apachePoiUtil.addPasswordToExcelFile();
    }

    @PostMapping("/login")
    public String login(HttpSession session){
        return userService.login(session);
    }

    @PostMapping("logout")
    public void logout(HttpSession session){
        userService.logout(session);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/find")
    public ResponseEntity<UserResponseDto> findById(@RequestParam Long userId) throws Exception {
        return ResponseEntity.ok(userService.findById(userId));
    }
}
