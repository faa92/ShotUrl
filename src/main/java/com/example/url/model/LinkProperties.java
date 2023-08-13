package com.example.url.model;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;
@ConfigurationProperties(prefix = "url.link")
@Value
public class LinkProperties {

    Set<String> urlHostBlacklist;
    Set<String> urlAllowedSchemes;
}
