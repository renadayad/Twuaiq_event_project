package com.example.tuwaiqevent_project.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class EventDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String eventTitel;
    private String location;
    private Date eventDate;
    private Time eventTime;
    private String requriment;
    private String catogroyEvent;
    private String food;
    private Integer NofNumber;
}
