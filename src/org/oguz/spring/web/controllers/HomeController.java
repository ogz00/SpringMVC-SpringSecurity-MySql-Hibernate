package org.oguz.spring.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
	// mapping root (/localhost:8080/SpringMVC/) url to home.jsp
	@RequestMapping("/")
	public String showHome()
	{

		return "home";
	}
	@RequestMapping("/admin")
	public String showAdmin()
	{

		return "admin";
	}

}
