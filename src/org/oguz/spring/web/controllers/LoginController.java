package org.oguz.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.model.dao.FormValidationGroup;
import org.oguz.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
	private static Logger logger = Logger.getLogger(LoginController.class);
	private UsersService usersService;


	@Autowired
	public void setUsersService(UsersService usersService)
	{
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin()
	{
		logger.info("execute user login ..");
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut()
	{
		logger.info("execute user logout ..");
		return "loggedout";
	}
	@RequestMapping("/users")
	public String showOffers(Model model)
	{
		// offersService.throwException();
		List<User> users = this.usersService.getAllUsers();

		model.addAttribute("users", users);
		logger.info("showing Users page ..");
		return "users";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model)
	{
		model.addAttribute("user", new User());
		logger.info("showing create new user page..");
		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Validated(FormValidationGroup.class) User user, BindingResult result)
	{
		if (result.hasErrors())
		{
			logger.info("execute error on new user ..");
			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername()))
		{
			logger.info("execute duplicate username ..");
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		usersService.createUser(user);

		logger.info("execute create new user .." + user.toString());
		return "accountcreated";


	}
	


}
