package com.thiagoDRangel.searchCEP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SearchCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchCepApplication.class, args);
		System.out.println("Server on the PORT 8080");
	}

}
