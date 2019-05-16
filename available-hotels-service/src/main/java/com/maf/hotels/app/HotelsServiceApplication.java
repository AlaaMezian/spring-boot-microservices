package com.maf.hotels.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.maf.hotels.client"})
@ComponentScan( 
		basePackages = {
		        "com.maf.hotels.controller" ,
				"com.maf.hotels.service",
				"com.maf.hotels.repository",
				"com.maf.hotels.client",
				"com.maf.hotels.config"
				}
		)
@EnableCircuitBreaker
public class HotelsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsServiceApplication.class, args);
	}

}
