package com.krotos.models;

public class Member {

    private long id;
    private String name;
    private String lastName;
    private int startNumber;
    private long runId;

    public Member(long id, String name, String lastName, int startNumber, long runId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.startNumber = startNumber;
        this.runId = runId;
    }

    @Override
    public String toString() {
        return "\n Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startNumber=" + startNumber +
                ", runId=" + runId +
                "}";
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public long getRunId() {
        return runId;
    }

    public void setRunId(long runId) {
        this.runId = runId;
    }
}
