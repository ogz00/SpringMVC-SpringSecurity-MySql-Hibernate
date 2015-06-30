package org.oguz.spring.web.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringEscapeUtils;
import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDao
{

	private NamedParameterJdbcTemplate jdbc;


	@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	// GET ALL OFFERS FROM OFFERS TABLE
	public List<Offer> getOffers()
	{
		return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true",

			new OfferRowMapper());
	}

	public List<Offer> getOffers(String username)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true and offers.username=:username",
			params, new OfferRowMapper());
	}

	// GET OFFER WITH ID
	public Offer getOffer(int id)
	{

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject(
			"select * from offers,users where offers.username=users.username and users.enabled=true and id =:id",
			params, new OfferRowMapper());
	}

	// CREATE SINGLE OFFER
	public boolean createOffer(Offer offer)
	{

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;


	}


	// CREATE Spring BatchUpdate methods with named params for multiple insertions and Transactional
	@Transactional
	public int[] create(List<Offer> offers)
	{

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		// if you dont want to namedparamjdbctemplate : jdbc.getJdbcOperations().batchUpdate(arg0)

		return jdbc.batchUpdate(
			"INSERT INTO `offers` (`username`, `text`) VALUES (:username,  :text);", params);
	}

	public boolean updateOffer(Offer offer)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offers set text=:text where id =:id", params) == 1;


	}

	public boolean delete(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.update("delete from offers where id=:id ", params) == 1;

	}


	public List<Offer> getAllOffers()
	{

		return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true",
			BeanPropertyRowMapper.newInstance(Offer.class));
	}


	/*
	 * TODO Always use like namedParameters, pereparedStatement etc. for protect your query against
	 * the SqlInjection attack.
	 * 
	 * new PreparedStatementSetter() { public void setValues(PreparedStatement preparedStatement)
	 * throws SQLException { preparedStatement.setString(1, "1"); } },
	 * 
	 * INSERT INTO `springtutorial`.`offers` (`id`, `name`, `email`, `text`) VALUES ('5', 'Oguz2',
	 * 'oguz2@gmail.com', 'I will submit this first time2');
	 */

}
