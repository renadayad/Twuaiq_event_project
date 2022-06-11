package com.example.tuwaiqevent_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor @NoArgsConstructor @Data
public class Api {
    private String message;
    private Integer status;
}
