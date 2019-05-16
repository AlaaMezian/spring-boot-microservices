package com.maf.crazyhotels.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan( 
		basePackages = {
		        "com.maf.crazyhotels.controller" ,
				"com.maf.crazyhotels.service",
				"com.maf.crazyhotels.repository"
				}
		)
public class CrazyHotelsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyHotelsServiceApplication.class, args);
	}

}
