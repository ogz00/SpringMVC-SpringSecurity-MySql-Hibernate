package org.oguz.spring.web.service;


import java.util.List;

import org.oguz.spring.web.model.Message;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.model.dao.MessagesDao;
import org.oguz.spring.web.model.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
public class UsersService
{
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private MessagesDao messagesDao;

	public void createUser(User user)
	{
		usersDao.createUser(user);
	}

	public boolean exists(String username)
	{
		return usersDao.exists(username);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	public List<User> getAllUsers()
	{
		return this.usersDao.getAllUsers();
	}

	public void sendMessage(Message message)
	{
		messagesDao.saveOrUpdate(message);
	}

}
