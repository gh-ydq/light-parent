package com.light.web.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@EnableAutoConfiguration
public class LoginController {
	
	@RequestMapping("/index")
	public String helloWorld(){
		return "index";
	}

	@RequestMapping("/indexbak")
	public String helloWorldBak(){
		return "indexBak";
	}
	
	@RequestMapping("/login")
	public String index(){
		return "login/login";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "home/home";
	}
	
	@RequestMapping("/optionItem")
	public String optionItem(){
		return "optionItem/optionItem";
	}
	

}
