package com.example.tuwaiqevent_project.repoistory;

import com.example.tuwaiqevent_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoistory extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
