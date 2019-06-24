package com.sakila.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontController {
	@RequestMapping(value="/api")
	public String showIndexPage() {
		return "Welcome To Sakila REST Project";
	}
}