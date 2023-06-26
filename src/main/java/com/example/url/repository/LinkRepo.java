package com.example.url.repository;


import com.example.url.model.UserProfile;

import java.util.List;

public interface LinkRepo {

    List<UserProfile> getAllProfiles();
    String findShotUrlByLongUrl (String longUrl);
    void createShotLink(String url);

    void delete (String longUrl);




}
