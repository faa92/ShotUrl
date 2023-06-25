package com.example.url.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter

public class UserProfile {
    private final long id;
    private final String longUrl;
    private final String shotUrl;
}
