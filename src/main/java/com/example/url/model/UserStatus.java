package com.example.url.model;

import lombok.Value;

import java.time.Instant;
@Value
public class UserStatus {
    Instant lastVisited;

    public boolean isFirstVisit(){return lastVisited == null;}

}
