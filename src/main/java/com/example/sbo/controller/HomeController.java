package com.example.sbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "Home Page.";
	}
	
	@GetMapping("/secure")
	public String secure() {
		return "Secure Page.";
	}
}
