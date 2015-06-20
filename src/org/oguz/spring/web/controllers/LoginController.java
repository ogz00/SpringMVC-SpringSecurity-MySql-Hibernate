package org.oguz.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{

	private UsersService usersService;


	@Autowired
	public void setUsersService(UsersService usersService)
	{
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin()
	{

		return "login";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model)
	{
		model.addAttribute("user", new User());

		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result)
	{
		if (result.hasErrors())
		{

			return "newaccount";
		}

		user.setAuthority("user");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername()))
		{

			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		usersService.createUser(user);


		return "accountcreated";


	}


}
