package com.example.url.repository;


import com.example.url.model.UserProfile;

import java.util.List;

public interface LinkRepo {

    List<UserProfile> getAllProfiles();
    String findShotUrlById (long id);
    void createNewLink(String url);

    void delete (long id);




}
