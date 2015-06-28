package org.oguz.spring.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
	private UsersService userService;
	
	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	public void setUserservice(UsersService userService)
	{
		this.userService = userService;
	}

	// mapping root (/localhost:8080/SpringMVC/) url to home.jsp
	@RequestMapping("/")
	public String showHome()
	{
		logger.info("Showing Home page ..");
		return "home";
	}

	@RequestMapping("/denied")
	public String showDenied()
	{
		logger.info("Access Denied!! ..");
		return "denied";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model)
	{

		List<User> users = this.userService.getAllUsersAuth();
		model.addAttribute("users", users);

		return "admin";
	}
}
