package com.example.url.service;

import com.example.url.model.Link;

import java.net.URI;
import java.util.List;
import java.util.Set;

public interface LinkService {

    Link getById(long id);
    Link create(URI url);
    List<Link> getByIds(Set<Long> ids);
}
