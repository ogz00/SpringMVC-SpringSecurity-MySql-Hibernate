package org.oguz.spring.web.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.oguz.spring.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("usersDao")
@Repository
public class UsersDao
{

	// private NamedParameterJdbcTemplate jdbc;
	/*
	 * @Autowired public void setDataSource(DataSource jdbc) { this.jdbc = new
	 * NamedParameterJdbcTemplate(jdbc); }
	 */

	@Autowired
	private PasswordEncoder passwordEncoder;


	private SessionFactory sessionFactory;


	public Session session()
	{
		return this.sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	public void createUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);


		// BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource(); params.addValue("username",
		 * user.getUsername()); params.addValue("password",
		 * passwordEncoder.encode(user.getPassword())); params.addValue("email", user.getEmail());
		 * params.addValue("name", user.getName()); params.addValue("enabled", user.isEnabled());
		 * params.addValue("authority", user.getAuthority());
		 * 
		 * return jdbc.update(
		 * "INSERT INTO `users` (`username`, `name`, `password`,`email`, `enabled`, `authority`) VALUES (:username, :name, :password,"
		 * + " :email, :enabled, :authority);", params) == 1;
		 */

		/*
		 * return jdbc.update(
		 * "INSERT INTO `authorities` (`username`, `authority`) VALUES (:username, :authority);",
		 * params) == 1;
		 */
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		return session().createQuery("from User").list();
		// return jdbc.query("select * from users",BeanPropertyRowMapper.newInstance(User.class));
	}

	public boolean exists(String username)
	{
		User user = getUser(username);
		return user != null;

		/*
		 * return jdbc.queryForObject("select count(*) from users where username = :username", new
		 * MapSqlParameterSource("username", username), Integer.class) > 0;
		 */
	}

	public User getUser(String username)
	{
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.idEq(username));
		return (User)criteria.uniqueResult();

	}


}
