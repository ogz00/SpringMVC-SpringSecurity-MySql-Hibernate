package org.oguz.spring.web.service;

import java.util.List;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.model.dao.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("offersService")
public class OffersService
{
	private OffersDAO offersDao;


	@Autowired
	public void setOffersDao(OffersDAO offersDao)
	{
		this.offersDao = offersDao;
	}


	public List<Offer> getCurrent()
	{
		return offersDao.getOffers();
	}

}
