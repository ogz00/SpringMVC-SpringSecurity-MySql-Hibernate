package org.oguz.spring.web.test.tests;


import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oguz.spring.web.model.User;

import org.oguz.spring.web.model.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:org/oguz/spring/web/config/dao--context.xml",
		"classpath:org/oguz/spring/web/config/security-context.xml",
		"classpath:org/oguz/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests
{
	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource datasource;

	@Before
	public void init()
	{

		JdbcTemplate jdbc = new JdbcTemplate(datasource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");

	}

	@Test
	public void testUsers()
	{
		User user = new User("oguzhankaracullu","Oguzhan Karacullu", "admin123", "oguzhan.karacullu@gmail.com", true, "ROLE_USER");


		//assertTrue("User creation should  return true", usersDao.createUser(user));
		 usersDao.createUser(user);

		List<User> users = usersDao.getAllUsers();

		assertEquals("Number of users should be 1.", 1, users.size());

		assertTrue("User should exist.", usersDao.exists(user.getUsername()));

		assertEquals("Created should be identical to retrieved user.", user, users.get(0));


	}

}
