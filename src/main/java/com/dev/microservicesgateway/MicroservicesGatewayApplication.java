package com.dev.microservicesgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroservicesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesGatewayApplication.class, args);
	}

	@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/customers/**")
                        .uri("http://localhost:8081"))
                .route(p -> p
                        .path("/loans/**")
                        .uri("http://localhost:8082"))
                .build();
    }

}
