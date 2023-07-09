package com.example.url.service;

import com.example.url.exception.BusinessException;
import com.example.url.model.Link;
import com.example.url.model.LinkProperties;
import com.example.url.repository.LinkRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.html.HTMLTableRowElement;

import java.net.URI;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService{

    private final LinkRepo linkRepo;
    private final LinkProperties linkProperties;


    @Transactional(readOnly = true)
    @Override
    public Link getById(long id) {
        return linkRepo.findById(id)
                .orElseThrow(()-> new BusinessException("Ссылка не найдена"));
    }

    @Transactional
    @Override
    public Link create(URI url) {
        Set<String> urlAllowedSchemes = linkProperties.getUrlAllowedSchemes();
        String scheme = url.getScheme();
        if (!urlAllowedSchemes.contains(scheme)){
            throw new BusinessException("Неверный адрес");
        }
        String host = url.getHost();
        if (linkProperties.getUrlHostBlacklist().contains(host)){
            throw new BusinessException("Сайт в чёрном списке");
        }
        return linkRepo.create(url);
    }


















}
