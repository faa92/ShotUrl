package com.example.url;

import com.example.url.model.Link;
import com.example.url.repository.LinkJdbcRepo;
import com.example.url.repository.LinkRepo;
import com.example.url.service.LinkService;
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

		LinkJdbcRepo linkJdbcRepo = context.getBean(LinkJdbcRepo.class);
//		linkJdbcRepo.findByIds();
	}
}













