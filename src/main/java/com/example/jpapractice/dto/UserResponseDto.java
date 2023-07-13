package com.example.jpapractice.dto;

import com.example.jpapractice.model.Team;
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
}
