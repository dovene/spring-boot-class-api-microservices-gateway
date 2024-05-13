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
						.uri("lb://CUSTOMER-MICROSERVICE")) // Load balancing for CUSTOMER-MICROSERVICE => name from eureka server
                .route(p -> p
                        .path("/loans/**")
						.uri("lb://LOAN-MICROSERVICE")) // Load balancing for Load balancing for LOAN-MICROSERVICE => name from eureka server
                .build();
    }

}
