package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.DTO.EventDTO;
import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.repoistory.AdminRepoistory;
import com.example.tuwaiqevent_project.repoistory.EventRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EventServies {
    private final EventRepoistory eventRepoistory;
private final UserServies userServies;
    public List<Event> getAllEvent(){

        return eventRepoistory.findAll();
    }
    public Optional<Event> getOnePlaner(Integer id){

        return eventRepoistory.findById(id);
    }

    public void addPlaner(Event event){
        eventRepoistory.save(event);

    }

public boolean Update(Event event){
 Optional<Event>current=eventRepoistory.findById(event.getEventid());
 if(current.isEmpty()){
     return false;
 }
  current.get().setCatogroyEvent(event.getCatogroyEvent());
 current.get().setLocation(event.getLocation());
 current.get().setNofNumber(event.getNofNumber());
 current.get().setRequriment(event.getRequriment());
 current.get().setFood(event.getFood());
 current.get().setEventDate(event.getEventDate());
 current.get().setEventTitel(event.getEventTitel());
 current.get().setEventTime(event.getEventTime());
 current.get().setPrice(event.getPrice());
 eventRepoistory.save(event);
 return true;
}

    public boolean delete(Integer id) {
        Optional<Event> current = getOnePlaner(id);
        if (current.isEmpty()) {
            return false;
        }
        eventRepoistory.deleteById(id);
        return true;
    }

    public void addUserToEvent(EventDTO eventDTO){
        Optional<User>user=userServies.getOneUser(eventDTO.getUserid());
        Event event=new Event(null, eventDTO.getEventTitel(), eventDTO.getCatogroyEvent(),
                eventDTO.getEventDate(),eventDTO.getEventTime(), eventDTO.getRequriment(),eventDTO.getLocation(),
        eventDTO.getFood(),eventDTO.getNofNumber(),user);
        user.get().getEvents().add(event);
        eventRepoistory.save(event);

    }
}
