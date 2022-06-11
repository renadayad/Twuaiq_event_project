package com.example.tuwaiqevent_project.repoistory;

import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepoistory extends JpaRepository<Admin,Integer> {
    Admin findAdminByUsername(String username);
}
