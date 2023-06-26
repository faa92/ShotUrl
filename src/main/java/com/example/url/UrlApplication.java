package com.example.url;

import com.example.url.repository.LinkJdbcRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UrlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UrlApplication.class, args);
	}

}
