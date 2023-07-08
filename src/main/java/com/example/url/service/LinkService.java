package com.example.url.service;

import com.example.url.model.Link;

import java.net.URI;

public interface LinkService {

    Link getById(long id);
    Link create(URI url);
}
