package com.example.url.controller;

import com.example.url.model.Link;
import com.example.url.model.UserStatus;
import com.example.url.service.LinkService;
import com.example.url.service.UserSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public abstract class LinkController {

    private final LinkService linkService;
    @Lookup
    protected  abstract UserSessionService getUserSessionService();
    @GetMapping("/")
    public ModelAndView getHomePage(@RequestParam(required = false)Long shotLinkId, UriComponentsBuilder urlBuilder) {
        UserSessionService userSessionService = getUserSessionService();
        UserStatus userStatus = userSessionService.getStatusOnVisit();//todo
        log.warn("!!!!!!!РАБОТАЕТ???!!!!!!!!");

        Link shortenedLink = shotLinkId == null
                ? null
                : linkService.getById(shotLinkId);
        String baseShortLinkUrl  = urlBuilder
                .path("/to/")
                .build()
                .toUriString();

        Map<String, Object> model = new HashMap<>();
        model.put("shortLink", shortenedLink);
        model.put("baseShortLinkUrl", baseShortLinkUrl);
        model.put("userStatus", userStatus);

        return new ModelAndView("home-page", model);
    }
    @PostMapping("/shorten")
    public ResponseEntity<?> create (@RequestParam URI url, UriComponentsBuilder urlBuilder){
        Link link = linkService.create(url);

        URI redirectUrl = urlBuilder
                .path("/")
                .queryParam("shortLinkId", link.getId())
                .build()
                .toUri();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectUrl)
                .build();
    }
    @GetMapping("/to/{linkId}")
    public ResponseEntity<?> redirect (@PathVariable long linkId){
        Link link = linkService.getById(linkId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(link.getLongUrl())
                .build();
    }

}

















