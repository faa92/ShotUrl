package com.example.url.repository;


public interface LinkRepo {

    String findShotUrlById (long id);
    void createNewLink(String url);

    boolean delete (long id);
    boolean updateLink (long id);




}
