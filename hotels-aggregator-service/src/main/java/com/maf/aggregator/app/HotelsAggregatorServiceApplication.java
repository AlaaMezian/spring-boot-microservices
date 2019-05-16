package com.maf.aggregator.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan( 
		basePackages = {
		        "com.maf.aggregator.controller" ,
				"com.maf.aggregator.service",
				"com.maf.aggregator.repository",
				"com.maf.aggregator.client"
				}
		)
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.maf.aggregator.client"})
public class HotelsAggregatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsAggregatorServiceApplication.class, args);
	}

}
