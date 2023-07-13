package com.example.jpapractice.dto;

import com.example.jpapractice.model.Team;
import com.example.jpapractice.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String name;
    private Team team;

    @Builder
    public UserResponseDto(Long id, String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.team = user.getTeam();
    }
}
