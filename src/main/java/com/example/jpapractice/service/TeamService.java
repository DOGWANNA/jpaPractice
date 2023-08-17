package com.example.jpapractice.service;

import com.example.jpapractice.dto.TeamRequestDto;
import com.example.jpapractice.dto.TeamResponseDto;
import com.example.jpapractice.model.Team;
import com.example.jpapractice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public ResponseEntity<TeamResponseDto> createTeam(TeamRequestDto teamRequestDto) {
        return teamRepository.createTeam(teamRequestDto);
    }

    @Transactional(readOnly = true)
    public TeamResponseDto findById(Long teamId) throws Exception {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(()-> new Exception("해당 팀이 존재하지 않습니다."));

        return TeamResponseDto.builder()
//                .id(team.getId())
                .name(team.getName())
                .build();
    }
}
