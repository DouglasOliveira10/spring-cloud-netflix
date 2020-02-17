package br.com.cadastrenos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrenos.services.ClientTwoService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private ClientTwoService bookService;
	
	@GetMapping
	public String getMessage() {
		return bookService.getMessageClientTwo();
	}
	

}
