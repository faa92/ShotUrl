package com.example.url.service;

import java.util.Set;

public interface UserSessionService {
    Set<Long> getLinksHistory();
    void addLinkToHistory(long linkId);
}
