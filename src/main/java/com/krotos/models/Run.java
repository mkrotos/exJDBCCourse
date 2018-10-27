package com.krotos.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Run {
    private long id;
    private String name;
    private String place;
    private LocalDate startDate;
    private LocalTime startTime;
    private int membersLimit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(int membersLimit) {
        this.membersLimit = membersLimit;
    }

    @Override
    public String toString() {
        return "\n Run{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", membersLimit=" + membersLimit +
                '}';
    }

    public Run(long id, String name, String place, LocalDate startDate, LocalTime startTime, int membersLimit) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.startDate = startDate;
        this.startTime = startTime;
        this.membersLimit = membersLimit;
    }
}
