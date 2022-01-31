package com.fdmgroup.ordersApiService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class OrdersApiServiceApplication {
	
	public static final String CART_API_URL = "http://localhost:8087";

	public static void main(String[] args) {
		SpringApplication.run(OrdersApiServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate cartsApiRestTemplate() {
		return new RestTemplateBuilder().rootUri(CART_API_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	@Bean
	public WebClient cartsApiWebClient() {
		return WebClient.builder().baseUrl(CART_API_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	


}
