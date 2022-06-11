package com.example.tuwaiqevent_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventid;
   private String eventTitel;

    private String location;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eventDate;


    @JsonFormat(pattern="HH:mm:ss")
    private Time eventTime;


    private String requriment;
   // @Column(nullable = false)
  // @NotEmpty
    private String catogroyEvent;
    private String food;
    //@NotNull
    private Integer NofNumber;
    private Double price;

    @ManyToOne
    @JsonIgnore
    private User user;


    @ManyToOne
    @JsonIgnore
    private Admin admin;


    public Event(Object o, String eventTitel, String catogroyEvent, Date eventDate, Time eventTime, String requriment, String location, String food, Integer nofNumber, Optional<User> user) {
    }
}
