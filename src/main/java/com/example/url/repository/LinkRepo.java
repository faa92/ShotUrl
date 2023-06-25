package com.example.url.repository;


public interface LinkRepo {

    String findShotUrlById (long id);
    void createNewLink(String url);

    void delete (long id);




}
