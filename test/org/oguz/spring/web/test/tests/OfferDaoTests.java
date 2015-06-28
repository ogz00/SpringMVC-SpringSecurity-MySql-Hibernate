package org.oguz.spring.web.test.tests;


import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.dao.OffersDao;

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
public class OfferDaoTests
{
	@Autowired
	private OffersDao offersDao;

	@Autowired
	private DataSource datasource;

	@Before
	public void init()
	{

		JdbcTemplate jdbc = new JdbcTemplate(datasource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");


	}

	@Test
	public void testCreateOffer()
	{

		Offer offer = new Offer("Oguzhan offer", "oguz@gmail.com", "OFFER OFFER OFFER");

		assertTrue("Offer creation should return true", offersDao.createOffer(offer));

		List<Offer> offers = offersDao.getAllOffers();

		assertEquals("NUmber of offer should be 1", 1, offers.size());

		assertEquals("Created should be identical to retrieved offer.", offer, offers.get(0));

		// Get the offer with ID filled in.
		offer = offers.get(0);

		offer.setText("Updated offer text.");
		assertTrue("Offer update should return true", offersDao.updateOffer(offer));

		Offer updated = offersDao.getOffer(offer.getId());

		assertEquals("Updated offer should match retrieved updated offer", offer, updated);

		offersDao.delete(offer.getId());

		List<Offer> empty = offersDao.getOffers();

		assertEquals("Offers lists should be empty.", 0, empty.size());


	}

}
