package com.esprit.microservice.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@SpringBootApplication
@EnableDiscoveryClient
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(); // Register RestTemplate as a Bean
	}

	@Autowired
	private MenuRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// Save some sample menus
			repository.save(new Menu("Pizza", "Delicious cheese pizza", BigDecimal.valueOf(8.99)));
			repository.save(new Menu("Burger", "Juicy beef burger", BigDecimal.valueOf(5.49)));
			repository.save(new Menu("Pasta", "Creamy Alfredo pasta", BigDecimal.valueOf(7.99)));
			repository.save(new Menu("Salad", "Fresh green salad", BigDecimal.valueOf(4.99)));

			// Fetch and print all menus
			repository.findAll().forEach(System.out::println);
		};
	}
}
