package com.example.jpapractice.dto;

import com.example.jpapractice.model.Team;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name;
    private Team team;
}
