package com.krotos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Run {
    private long id;
    private String name;
    private String place;
    private LocalDate startDate;
    private LocalTime startTime;
    private int membersLimit;


}
