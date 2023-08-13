package com.example.url.controller;

import com.example.url.model.Link;
import com.example.url.service.LinkService;
import com.example.url.service.UserSessionService;
import lombok.RequiredArgsConstructor;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public abstract class LinkController {

    private final LinkService linkService;
    @Lookup
    protected  abstract UserSessionService getUserSessionService();
    @GetMapping("/")
    public ModelAndView getHomePage(UriComponentsBuilder urlBuilder) {
        UserSessionService userSessionService = getUserSessionService();
        Set<Long> shortLinkIds = userSessionService.getLinksHistory();

        List<Link> sortLinks = linkService.getByIds(shortLinkIds);

        String baseShortLinkUrl  = urlBuilder
                .path("/to/")
                .build()
                .toUriString();

        Map<String, Object> model = new HashMap<>();
        model.put("shortLinks", sortLinks);
        model.put("baseShortLinkUrl", baseShortLinkUrl);

        return new ModelAndView("home-page", model);
    }
    @PostMapping("/shorten")
    public ResponseEntity<?> create (@RequestParam URI url, UriComponentsBuilder urlBuilder){
        Link link = linkService.create(url);

        UserSessionService userSessionService = getUserSessionService();
        userSessionService.addLinkToHistory(link.getId());

        URI redirectUrl = urlBuilder
                .path("/")
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


















