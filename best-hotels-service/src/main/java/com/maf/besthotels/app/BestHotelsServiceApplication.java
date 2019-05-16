package com.maf.besthotels.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( 
		basePackages = {
		        "com.maf.besthotels.controller" ,
				"com.maf.besthotels.service",
				"com.maf.besthotels.repository"
				}
		)
@EnableDiscoveryClient
public class BestHotelsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestHotelsServiceApplication.class, args);
	}

}
