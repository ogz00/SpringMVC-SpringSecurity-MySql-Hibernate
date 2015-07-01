package org.oguz.spring.web.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Component("offersDao")
@Transactional
public class OffersDao
{

//	private NamedParameterJdbcTemplate jdbc;
	 
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}

	public Session session()
	{
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Offer> getOffers(String username)
	{
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.enabled", true));
		criteria.add(Restrictions.eqOrIsNull("u.username", username));
		return criteria.list();
		
		/*MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true and offers.username=:username",
			params, new OfferRowMapper());*/
	}


	public Offer getOffer(int id)
	{
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.enabled", true));
		criteria.add(Restrictions.idEq(id));
		return (Offer)criteria.uniqueResult();
		
		
		/*MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject(
			"select * from offers,users where offers.username=users.username and users.enabled=true and id =:id",
			params, new OfferRowMapper());*/
	}

	public void saveOrUpdate(Offer offer)
	{
		session().saveOrUpdate(offer);

		/*BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;*/	
	}


	public boolean delete(int id)
	{
		Query query= session().createQuery("delete from Offer where id =:id");
		query.setLong("id", id);
		return query.executeUpdate()==1;
				
		/*MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("delete from offers where id=:id ", params) == 1;*/
	}


	@SuppressWarnings("unchecked")
	public List<Offer> getAllOffers()
	{
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return criteria.list();
		
		/*return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true",
			BeanPropertyRowMapper.newInstance(Offer.class));*/
	}
	
	
	
	// CREATE Spring BatchUpdate methods with named params for multiple insertions and Transactional
		/*@Transactional
		public int[] create(List<Offer> offers)
		{

			SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
			// if you dont want to namedparamjdbctemplate : jdbc.getJdbcOperations().batchUpdate(arg0)

			return jdbc.batchUpdate(
				"INSERT INTO `offers` (`username`, `text`) VALUES (:username,  :text);", params);
		}*/

		/*public void updateOffer(Offer offer)
		{
			session().update(offer);
			/*BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
			return jdbc.update("update offers set text=:text where id =:id", params) == 1;

		}*/
	
	/*@SuppressWarnings("unchecked")
	public List<Offer> getOffers()
	{
			return jdbc.query(
			"select * from offers,users where offers.username=users.username and users.enabled=true",

			new OfferRowMapper());
	
	}*/
	
	/*@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}*/


}
