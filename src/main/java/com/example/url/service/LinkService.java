package com.example.url.service;

import com.example.url.model.Link;

import java.net.URI;
import java.util.Optional;

public interface LinkService {

    Optional<Link> findById(long id) ;
    Link create(URI url);
}
