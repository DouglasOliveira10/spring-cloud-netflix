package br.com.cadastrenos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping
	public String getMessage() {
		return "Cliente 2 diz Ola! Da porta: " + port;
	}
	

}
