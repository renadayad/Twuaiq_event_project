package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.repoistory.AdminRepoistory;
import com.example.tuwaiqevent_project.repoistory.UserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyAdminServies implements UserDetailsService {
    private final AdminRepoistory adminRepoistory;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin=adminRepoistory.findAdminByUsername(username);
        if(admin==null){
            throw new UsernameNotFoundException("Username not found");
        }

        return admin;
    }
    }

