package com.example.url.repository;

import com.example.url.model.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LinkJdbcRepo implements LinkRepo{
    private final NamedParameterJdbcOperations jdbcOperations;


    @Override
    public Optional<Link> findById(long id) {
        String sql = """
                SELECT id, url
                FROM users_links
                WHERE  id = :linkId
                """;
        return jdbcOperations.query(sql, Map.of("linkId", id), this::mapToLink)
                .stream()
                .findFirst();
    }
    @Override
    public Link create(URI url) {
        String sql = """
                INSERT INTO users_links (url)
                VALUES (:url)
                RETURNING id
                """;
        Integer id = jdbcOperations.queryForObject(sql,
                Map.of("url", url.toString()), Integer.class);
        return new Link(id, url);
    }

    private Link mapToLink(ResultSet resultSet, int rowNum) throws SQLException {
        return new Link(
                resultSet.getLong("id"),
                URI.create(resultSet.getString("url"))
        );
    }


}
