package com.example.jpapractice.repository;

import com.example.jpapractice.dto.UserRequestDto;
import com.example.jpapractice.dto.UserResponseDto;
import com.example.jpapractice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @PersistenceContext // EntityManager를 빈으로 주입받을 때 사용.
    private EntityManager em;
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto) {
        User user = findByName(userRequestDto.getName()).orElse(null);
        if(user != null){
            throw new RuntimeException("중복된 이름이 존재합니다.");
        }
        user = User.builder()
                .name(userRequestDto.getName())
                .team(userRequestDto.getTeam())
                .build();

        em.persist(user);
        close(em);

        return ResponseEntity.ok(UserResponseDto.builder()
                .name(user.getName())
                .team(user.getTeam())
                .build());
    }
    public Optional<User> findById(Long userId) {
        User user = em.find(User.class, userId);
        close(em);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByName(String userName){
        List<User> users = em.createQuery("select u from users as u where u.name = :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();
        close(em);
        return users.stream().findAny();
    }

    public void close(EntityManager em){
        em.close();
    }
}
