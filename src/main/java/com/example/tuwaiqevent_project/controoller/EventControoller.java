package com.example.tuwaiqevent_project.controoller;


import com.example.tuwaiqevent_project.DTO.EventDTO;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.servies.EventServies;
import com.example.tuwaiqevent_project.servies.UserServies;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/event")
public class EventControoller {

    private final EventServies eventServies;
    Logger log = LoggerFactory.getLogger(EventControoller.class);


    @GetMapping
    public ResponseEntity<List<Event>> getAllEvent() {
        log.info("Event are return by through getAllEvent()");

        return ResponseEntity.status(201).body(eventServies.getAllEvent());
    }


    @PostMapping
    public ResponseEntity addPlaner(@RequestBody Event event) {
        log.info("Event are added by through addEvent()");

        eventServies.addPlaner(event);
        return ResponseEntity.status(200).body("Planer added!");
    }

    @PostMapping("/usertoevent")
    public ResponseEntity addEvent(@RequestBody EventDTO eventDTO) {
        log.info("Add Event");

        eventServies.addUserToEvent(eventDTO);
        return ResponseEntity.status(200).body("User add to Event!");
    }

  @PutMapping
    public ResponseEntity UpdateEvent(@RequestBody Event event) {
      log.info("Update Event!");

      boolean ischeck= eventServies.Update(event);
       if (ischeck!=true){
           return ResponseEntity.status(400).body("Event can't Update!");
       }
        return ResponseEntity.status(200).body("Event Update!");
    }


    @DeleteMapping("/{eventid}")
    public ResponseEntity deleteEvent(@PathVariable Integer eventid) {
        log.info("Delete Event!");

        boolean ischeck=eventServies.delete(eventid);
        if (ischeck!=true){
            return ResponseEntity.status(400).body("Event can't delete!");

        }
        return ResponseEntity.status(200).body("Event delete!");
    }
}