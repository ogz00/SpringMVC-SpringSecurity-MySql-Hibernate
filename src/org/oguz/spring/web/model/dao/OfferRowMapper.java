package org.oguz.spring.web.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.springframework.jdbc.core.RowMapper;

public class OfferRowMapper implements RowMapper<Offer>
{

	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Offer offer = new Offer();
		User user = new User();

		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));

		offer.setId(rs.getInt("id"));
		offer.setText(rs.getString("text"));
		offer.setUser(user);


		return offer;
	}

}
