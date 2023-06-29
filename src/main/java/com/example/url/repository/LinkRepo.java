package com.example.url.repository;


import com.example.url.model.Link;

import java.net.URI;
import java.util.Optional;

public interface LinkRepo {

    Optional<Link> findById(long id);
    Link create(URI url);




}
