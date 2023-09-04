//package com.example.jpapractice.repository;
//
//import com.example.jpapractice.dto.TeamRequestDto;
//import com.example.jpapractice.dto.TeamResponseDto;
//import com.example.jpapractice.dto.UserRequestDto;
//import com.example.jpapractice.dto.UserResponseDto;
//import com.example.jpapractice.model.Team;
//import com.example.jpapractice.model.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class TeamRepository {
//    @PersistenceContext // EntityManager를 빈으로 주입받을 때 사용.
//    private EntityManager em;
//
//    public ResponseEntity<TeamResponseDto> createTeam(TeamRequestDto teamRequestDto) {
//        Team team = findByName(teamRequestDto.getName()).orElse(null);
//        if(team != null){
//            throw new RuntimeException("중복된 팀명이 존재합니다.");
//        }
//
//        team = Team.builder()
//                .name(teamRequestDto.getName())
//                .build();
//
//        em.persist(team);
//
//        close(em);
//
//        return ResponseEntity.ok(TeamResponseDto.builder()
//                .name(team.getName())
//                .build());
//    }
//
//    public Optional<Team> findById(Long teamId){
//        Team team = em.find(Team.class, teamId);
//        close(em);
//        return Optional.ofNullable(team);
//    }
//
//    public Optional<Team> findByName(String teamName){
//        List<Team> teams = em.createQuery("select t from Team as t where t.name = :teamName", Team.class)
//                .setParameter("teamName", teamName)
//                .getResultList();
//        close(em);
//        return teams.stream().findAny();
//    }
//
//    public void close(EntityManager em){
//        em.close();
//    }
//}
package com.example.jpapractice.repository;

import com.example.jpapractice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
