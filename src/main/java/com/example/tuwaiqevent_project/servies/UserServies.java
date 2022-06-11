package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.DTO.EventDTO;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.Payment;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.repoistory.EventRepoistory;
import com.example.tuwaiqevent_project.repoistory.UserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServies {
    private final UserRepoistory userRepoistory;


    public List<User> getAllUser(){

        return userRepoistory.findAll();
    }
    public Optional<User> getOneUser(Integer id) {

        return userRepoistory.findById(id);
    }
    public void addUser(User user){

        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepoistory.save(user);

    }

    public boolean Update(User user){
        Optional<User>current=userRepoistory.findById(user.getId());
        if(current.isEmpty()){
            return false;
        }
        current.get().setEmail(user.getEmail());
        current.get().setPassword(user.getPassword());
        current.get().setUsername(user.getUsername());
        current.get().setPhoneNumber(user.getPhoneNumber());
        userRepoistory.save(user);
        return true;
    }

    public boolean delete(Integer id){
    Optional<User> current = getOneUser(id);
        if (current.isEmpty()) {
        return false;
    }
        userRepoistory.deleteById(id);
        return true;
}


}
