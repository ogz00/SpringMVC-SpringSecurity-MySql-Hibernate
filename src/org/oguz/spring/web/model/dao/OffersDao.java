package org.oguz.spring.web.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringEscapeUtils;
import org.oguz.spring.web.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
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


		return jdbc.query("select * from offers ",

		// PREPARE RESULT SET
			new RowMapper<Offer>()
			{

				@Override
				public Offer mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Offer offer = new Offer();

					offer.setId(rs.getInt("id"));
					offer.setName(rs.getString("name"));
					offer.setText(rs.getString("text"));
					offer.setEmail(rs.getString("email"));

					return offer;
				}
			});
	}

	// GET OFFER WITH ID
	public Offer getOffer(int id)
	{

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id = :id", params,

		new RowMapper<Offer>()
		{

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));

				return offer;
			}
		});
	}

	// CREATE SINGLE OFFER
	public boolean createOffer(Offer offer)
	{

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update(
			"INSERT INTO `springtutorial`.`offers` (`name`, `email`, `text`) VALUES (:name, "
				+ ":email, :text);", params) == 1;


	}


	// CREATE Spring BatchUpdate methods with named params for multiple insertions and Transactional
	@Transactional
	public int[] create(List<Offer> offers)
	{

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		// if you dont want to namedparamjdbctemplate : jdbc.getJdbcOperations().batchUpdate(arg0)

		return jdbc.batchUpdate(
			"INSERT INTO `springtutorial`.`offers` (`name`, `email`, `text`) VALUES (:name, "
				+ ":email, :text);", params);
	}

	public boolean updateOffer(Offer offer)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offers set name=:name, email=:email, text=:text where id =:id",
			params) == 1;


	}

	public boolean delete(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.update("delete from offers where id=:id ", params) == 1;

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
