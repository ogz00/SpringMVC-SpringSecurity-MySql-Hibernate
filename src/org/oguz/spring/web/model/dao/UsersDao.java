package org.oguz.spring.web.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.oguz.spring.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersDao")
public class UsersDao
{

	private NamedParameterJdbcTemplate jdbc;


	@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}


	@Transactional
	public boolean createUser(User user)
	{

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		jdbc.update(
			"INSERT INTO `springtutorial`.`users` (`username`, `password`,`email`, `enabled`) VALUES (:username, :password,"
				+ " :email, :enabled);", params);

		return jdbc.update(
			"INSERT INTO `springtutorial`.`authorities` (`username`, `authority`) VALUES (:username, :authority);",
			params) == 1;
	}
	
	// GET ALL OFFERS FROM OFFERS TABLE
		public List<User> getUsers()
		{


			return jdbc.query("select * from users ",

			// PREPARE RESULT SET
				new RowMapper<User>()
				{

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException
					{
						User user = new User();

						user.setUsername(rs.getString("username"));
						user.setEmail(rs.getString("email"));

						return user;
					}
				});
		}


	public boolean exists(String username)
	{

		return jdbc.queryForObject("select count(*) from springtutorial.users where username = :username",
			new MapSqlParameterSource("username", username), Integer.class) > 0;
	}


}
