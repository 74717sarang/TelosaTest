package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestClass {

	@GetMapping("/hello")
	public String test() {
		System.out.println("hello test1");
		return "Hello test1";
	}
	
	
	
	
}
