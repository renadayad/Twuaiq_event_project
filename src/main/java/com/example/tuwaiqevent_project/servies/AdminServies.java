package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.exceptions.InvalidException;
import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.repoistory.AdminRepoistory;
import com.example.tuwaiqevent_project.repoistory.EventRepoistory;
import com.example.tuwaiqevent_project.repoistory.UserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServies {

    private final AdminRepoistory adminRepoistory;
public final EventServies eventServies;
public final EventRepoistory eventRepoistory;
final UserServies userServies;
    public List<Admin> getAllAdmin() {

        return adminRepoistory.findAll();
    }

   public Optional<Admin> getOneAdmin(Integer id) {

        return adminRepoistory.findById(id);

    }
    public Optional<Event> viewDetails(Integer id){

        return eventServies.getOnePlaner(id);
    }


    public void addAdmin(Admin admin) {
        String hashedPassword=new BCryptPasswordEncoder().encode(admin.getPassword());
        admin.setPassword(hashedPassword);
        adminRepoistory.save(admin);

    }
    public boolean Update(Admin admin){

        Optional<Admin>current=adminRepoistory.findById(admin.getId());
        if(current.isEmpty()){
            return false;
        }
        current.get().setPassword(admin.getPassword());
        current.get().setUsername(admin.getUsername());
        adminRepoistory.save(admin);
             return true;
    }


    public boolean delete(Integer id) {
       Optional<Admin> current = getOneAdmin(id);
        if (current.isEmpty()) {
            return false;
        }
        adminRepoistory.deleteById(id);
        return true;
    }
}