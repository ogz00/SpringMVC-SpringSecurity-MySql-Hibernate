package org.oguz.spring.web.test.tests;


import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.User;
import org.oguz.spring.web.model.dao.OffersDao;
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
public class OfferDaoTests
{
	@Autowired
	private OffersDao offersDao;
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
	public void testOffers()
	{
		User user = new User("oguzhankaracullu", "Oguzhan Karacullu", "admin123",
			"oguzhan.karacullu@gmail.com", true, "ROLE_USER");

		 usersDao.createUser(user);

		Offer offer = new Offer(user, "OFFER OFFER OFFER");

		 offersDao.saveOrUpdate(offer);

		List<Offer> offers = offersDao.getAllOffers();

		assertEquals("NUmber of offer should be 1", 1, offers.size());

		assertEquals("Created should be identical to retrieved offer.", offer, offers.get(0));

		// Get the offer with ID filled in.
		offer = offers.get(0);

		offer.setText("Updated offer text.");
		offersDao.saveOrUpdate(offer);

		Offer updated = offersDao.getOffer(offer.getId());

		assertEquals("Updated offer should match retrieved updated offer", offer, updated);


		// TEST GET BY ID
		Offer offer2 = new Offer(user, "This is a test for user");

		this.offersDao.saveOrUpdate(offer2);
		
		List<Offer> userOffers = offersDao.getOffers(user.getUsername());
		assertEquals("Should be 2 offers for user", 2, userOffers.size());

		List<Offer> secondList = offersDao.getAllOffers();

		for (Offer current : secondList)
		{
			Offer retrieved = offersDao.getOffer(current.getId());

			assertEquals("Offers ID shoudl be match offer from list", current, retrieved);
		}

		// Test deletion

		offersDao.delete(offer.getId());

		List<Offer> empty = offersDao.getAllOffers();

		assertEquals("Offers lists should be empty.", 1, empty.size());

	}

}
