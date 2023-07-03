package com.example.url.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.List;
import java.util.Map;
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "blocked")
@Value
public class BlackList {
    List<String> blackList;
}
