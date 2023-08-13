package com.example.url.repository;


import com.example.url.model.Link;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LinkRepo {

    Optional<Link> findById(long id);
    Link create(URI url);

    List<Link> findByIds(Set<Long> ids);




}
