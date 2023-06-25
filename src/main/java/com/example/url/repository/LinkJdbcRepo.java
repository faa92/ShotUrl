package com.example.url.repository;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class LinkJdbcRepo implements LinkRepo{
    private final JdbcOperations jdbcOperations;

    public LinkJdbcRepo(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public String findShotUrlById(long id) {
        return jdbcOperations.queryForObject("""
                        SELECT  shot_url
                        FROM    users_links
""", String.class);
    }

    @Override
    public void createNewLink(String url) {
        jdbcOperations.update("""
                    INSERT INTO users_links (long_url)
                    VALUES ?
""", url);
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean updateLink(long id) {
        return false;
    }
}
