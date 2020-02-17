package br.com.cadastrenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/eureka")
public class EurekaDiscoveryController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;

	@GetMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@GetMapping("/service-instances")
	public List<String> serviceInstances() {
		return this.discoveryClient.getServices();
	}

}
