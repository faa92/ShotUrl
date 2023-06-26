package com.example.url.repository;

import com.example.url.model.UserProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class LinkJdbcRepo implements LinkRepo{
    private final JdbcOperations jdbcOperations;

    public LinkJdbcRepo(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        return jdbcOperations.query("""
                SELECT *
                FROM user_links
                """, (rs, rowNum) -> new UserProfile(
                        rs.getLong("id"),
                        rs.getString("long_url"),
                        rs.getString("shot_url")
        ));
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
    public void delete(long id) {
        jdbcOperations.update("""
                    DELETE FROM users_links
                    WHERE id = ?;
""",id);
    }
}
