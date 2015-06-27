package org.oguz.spring.web.service;

import java.util.List;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.dao.OffersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service("offersService")
public class OffersService
{
	private OffersDao offersDao;


	@Autowired
	public void setOffersDao(OffersDao offersDao)
	{
		this.offersDao = offersDao;
	}


	public List<Offer> getCurrent()
	{
		return offersDao.getOffers();
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void createOffer(Offer offer)
	{
		offersDao.createOffer(offer);

	}

	
	public void throwException(){
		offersDao.getOffer(9999);
	}
}
