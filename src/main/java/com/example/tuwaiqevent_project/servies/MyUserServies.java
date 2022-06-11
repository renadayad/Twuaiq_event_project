package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.repoistory.UserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserServies implements UserDetailsService {
    private final UserRepoistory userRepoistory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepoistory.findUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }

        return user;
    }
    }

