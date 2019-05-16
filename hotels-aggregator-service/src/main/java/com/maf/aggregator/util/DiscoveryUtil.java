package com.maf.aggregator.util;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

/** 
 * 
 * @author Ala'a Mezian
 * @note this class can be used with Rest Template to determine URLs for services and services name
 * i didn't use this class because i used feign client which integrate with Eruka naming server 
 * so it determine the URL of the service automatically based on service name ,
 * and require less code to write 
 * 
 */
@Component
public class DiscoveryUtil {

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * @author Ala'a Mezian
	 * @param serviceId   the name of the service you want to discover it base URI
	 * @param fallbackUri in case the service is down for some reason
	 * @return the Base URI for service provider based on service name
	 */
	private URI getServiceUrl(String serviceId, String fallbackUri) {
		URI uri = null;
		try {
			ServiceInstance instance = loadBalancer.choose(serviceId);
			uri = instance.getUri();

			System.out.println("Resolved serviceId '{}' to URL '{}'." + serviceId + "  " + uri);

		} catch (RuntimeException e) {
			// Eureka not available, use fallback
			uri = URI.create(fallbackUri);
			System.out.println("Failed to resolve serviceId '{}'. Fallback to URL '{}'." + serviceId + " " + uri);
		}

		return uri;
	}

	/**
	 * @author Ala'a Mezian
	 * @return the names of all service providers names registered with in the Eureka
	 *         naming server
	 */
	List<String> discoverProvidersNames() {
		List<String> applications = discoveryClient.getServices();
		return applications;
	}
}
