package org.oguz.spring.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.oguz.spring.web.model.Message;
import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.model.dao.FormValidationGroup;
import org.oguz.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController
{
	private static Logger logger = Logger.getLogger(LoginController.class);
	private UsersService usersService;

	@Autowired
	private MailSender mailSender;


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
	public String createAccount(@Validated(FormValidationGroup.class) User user,
		BindingResult result)
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

	@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getMessages(Principal principal)
	{
		List<Message> messages = null;

		if (principal == null)
		{
			messages = new ArrayList<Message>();
		}
		else
		{
			String username = principal.getName();
			messages = usersService.getMessages(username);
		}

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("messages", messages);
		data.put("number", messages.size());
		return data;

	}

	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> sendMessage(Principal principal,
		@RequestBody Map<String, Object> data)
	{
		String text = (String)data.get("text");
		String name = (String)data.get("name");
		String email = (String)data.get("email");
		Integer target = (Integer)data.get("target");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("oguzhan.karacullu@biznet.com.tr");
		mail.setTo(email);
		mail.setSubject("Re: " + name + ", your message");
		mail.setText(text);

		try
		{
			mailSender.send(mail);
		}
		catch (MailAuthenticationException e)
		{
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		catch (MailSendException e)
		{
			e.printStackTrace();
			logger.info(e.getMessage());
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
			logger.info(ex.getClass());
			logger.info("Can't sent message");
		}


		Map<String, Object> rval = new HashMap<String, Object>();
		rval.put("success", true);
		rval.put("target", target);
		return rval;

	}

	@RequestMapping("/messages")
	public String showMessages()
	{
		logger.info("Showing messages");
		return "messages";
	}

}
