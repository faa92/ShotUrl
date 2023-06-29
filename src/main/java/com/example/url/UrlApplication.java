package com.example.url;

import com.example.url.model.Link;
import com.example.url.repository.LinkRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URI;
import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UrlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UrlApplication.class, args);

		LinkRepo linkRepo = context.getBean(LinkRepo.class);

		Link link = linkRepo.create(URI.create("https://google.com"));
		Optional<Link> byId = linkRepo.findById(2);
	}

}
