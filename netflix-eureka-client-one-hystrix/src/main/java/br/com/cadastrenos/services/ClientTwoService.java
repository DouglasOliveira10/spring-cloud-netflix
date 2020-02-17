package br.com.cadastrenos.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientTwoService {

	@HystrixCommand(fallbackMethod = "reliable")
	public String getMessageClientTwo() {
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = URI.create("http://localhost:8080/netflix-eureka-two/message");
		return restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "@Hystrix entrou em ação, seriço original indisponivel!";
	}

}