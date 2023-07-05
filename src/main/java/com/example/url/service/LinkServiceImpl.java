package com.example.url.service;

import com.example.url.config.BlackList;
import com.example.url.model.Link;
import com.example.url.repository.LinkRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService{
    public static final String VALID_SCHEME_HTTP = "http";
    public static final String VALID_SCHEME_HTTPS = "https";

    private final BlackList blackList;
    private final LinkRepo linkRepo;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Optional<Link> findById(long id) {
        return linkRepo.findById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Link create(URI url) {
        try {
            if (isValidateUrl(url)) {
                return linkRepo.create(url);
            } else throw new IllegalArgumentException("Invalid URL");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isValidateUrl (URI url) throws URISyntaxException {
        if (url.getScheme().equals(VALID_SCHEME_HTTP) || url.getScheme().equals(VALID_SCHEME_HTTPS)) {
            for(String link : blackList.getBlackList()) {
                if (url.getHost().equals(link)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

















}
