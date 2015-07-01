package org.oguz.spring.web.model.dao;


import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.oguz.spring.web.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Component("messagesDao")
@Transactional
public class MessagesDao
{
	private static Logger logger = Logger.getLogger(MessagesDao.class);
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
	public List<Message> getMessages()
	{
		Criteria criteria = session().createCriteria(Message.class);
		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String username)
	{
		Criteria criteria = session().createCriteria(Message.class);
		criteria.add(Restrictions.eqOrIsNull("username", username));
		return criteria.list();
	}


	public void saveOrUpdate(Message message)
	{
		System.out.println(message);
		session().saveOrUpdate(message);
	}

	public Message getMessage(int id)
	{
		Criteria criteria = session().createCriteria(Message.class);
		criteria.add(Restrictions.idEq(id));
		return (Message)criteria.uniqueResult();
	}


	public boolean delete(int id)
	{
		Query query = session().createQuery("delete from Message where id =:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;

	}


}