package com.example.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/")
	public String validateUser() {
		return "Hello User... Authentication and Authorization is successful.";
	}
}
