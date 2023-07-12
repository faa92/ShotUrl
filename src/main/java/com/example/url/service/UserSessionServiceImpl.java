package com.example.url.service;

import com.example.url.model.UserStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserSessionServiceImpl implements UserSessionService{

    private final AtomicReference<UserStatus> userStatusAtomicReference;

    public UserSessionServiceImpl () {
        userStatusAtomicReference = new AtomicReference<>(new UserStatus(null));
    }
    @Override
    public UserStatus getStatusOnVisit() {
        Instant visitedAt = Instant.now();
        UserStatus nextStatus = new UserStatus(visitedAt);
        UserStatus currentStatus = userStatusAtomicReference.getAndSet(nextStatus);

        return currentStatus;
    }

}
