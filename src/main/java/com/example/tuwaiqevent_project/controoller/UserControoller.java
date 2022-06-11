package com.example.tuwaiqevent_project.controoller;


import com.example.tuwaiqevent_project.DTO.EventDTO;
import com.example.tuwaiqevent_project.model.Api;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.servies.EventServies;
import com.example.tuwaiqevent_project.servies.UserServies;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/")
public class UserControoller {
    Logger log=LoggerFactory.getLogger(UserControoller.class);

    private final UserServies userServies;
private final EventServies eventServies;

    @GetMapping("getalluser")
    public ResponseEntity<?> getAllUser() {
        log.info("User are return by through getAllUser()");


        return ResponseEntity.status(201).body(userServies.getAllUser());
    }

    @GetMapping("{id}")
    public ResponseEntity getoneUser(@PathVariable Integer id) {
        log.info("User are return by through getoneUser()");

        return ResponseEntity.status(201).body(userServies.getOneUser(id));
    }

    @GetMapping("login")
    public ResponseEntity<?> LoginUser() {
        log.info("User are login by through getAllUser()");

        return ResponseEntity.status(200).body(new Api("Welcome User",200) );
    }

    @PostMapping("register")
    public ResponseEntity addUser(@RequestBody User user, Errors errors) {
        log.info("User are register by through addUser()");

        if(errors.hasErrors()) {
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(massage,400));
        }
        userServies.addUser(user);
        return ResponseEntity.status(200).body("User added!");

    }


@PutMapping("updateuser")
public ResponseEntity UpdateUser(@RequestBody User user) {
    log.info("User are Update by through UpdateUser()");

    boolean ischeck=userServies.Update(user);
        if(ischeck!=true){
            return ResponseEntity.status(400).body("User can't Update!");

        }
        return ResponseEntity.status(200).body("User Update!");
    }

    @DeleteMapping("deleteUser/{userid}")
    public ResponseEntity deleteUser(@PathVariable Integer userid) {
        log.info("User are delete by through deleteUser()");


        boolean ischeck=userServies.delete(userid);

        if (ischeck!=true){
            return ResponseEntity.status(400).body("User can't delete!");
        }
        return ResponseEntity.status(200).body("User delete!");
    }

}
