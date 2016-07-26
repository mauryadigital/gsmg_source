package com.pts.ats.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


	@RequestMapping("/")
	public String showHome() {	
		return "index";
	}
	@RequestMapping("/admin")
	public String showAdmin() {	
		return "admin";
	}
}
