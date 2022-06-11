package com.example.tuwaiqevent_project.repoistory;

import com.example.tuwaiqevent_project.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepoistory extends JpaRepository<Event,Integer> {
}
