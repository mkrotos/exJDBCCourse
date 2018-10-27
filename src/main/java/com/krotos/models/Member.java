package com.krotos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private long id;
    private String name;
    private String lastName;
    private int startNumber;
    private long runId;


}
