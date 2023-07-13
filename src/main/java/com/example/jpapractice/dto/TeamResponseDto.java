package com.example.jpapractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamResponseDto {
    private String name;

    @Builder
    public TeamResponseDto(Long id, String name) {
        this.name = name;
    }
}
