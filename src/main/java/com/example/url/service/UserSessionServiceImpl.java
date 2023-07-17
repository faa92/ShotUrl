package com.example.url.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequiredArgsConstructor
public class UserSessionServiceImpl implements UserSessionService{

    private final Set<Long> linkIds = ConcurrentHashMap.newKeySet();


    @Override
    public Set<Long> getLinksHistory() {
        return Set.copyOf(linkIds);
    }

    @Override
    public void addLinkToHistory(long linkId) {
        linkIds.add(linkId);
    }
}
