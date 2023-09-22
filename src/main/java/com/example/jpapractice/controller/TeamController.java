package com.example.jpapractice.controller;

import com.example.jpapractice.dto.TeamResponseDto;
import com.example.jpapractice.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TeamController {
    private final TeamService teamService;

//    @PostMapping("/team")
//    public ResponseEntity<TeamResponseDto> createTeam(@RequestBody TeamRequestDto teamRequestDto){
//        return teamService.createTeam(teamRequestDto);
//    }

    @GetMapping("/team")
    public ResponseEntity<TeamResponseDto> findById(@RequestParam Long userId) throws Exception {
        return ResponseEntity.ok(teamService.findById(userId));
    }
}

