package org.oguz.spring.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.StringEscapeUtils;
import org.oguz.spring.web.validation.ValidEmail;
import org.springframework.stereotype.Component;

@Component
public class Offer
{

	private int id;
	
	@Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters!")
	private String name;
	
	@NotNull
	//@Pattern(regexp = ".*\\@.*\\..*", message = "This does not appear to be a valid email address")
	@ValidEmail(min=6)
	private String email;
	
	@Size(min = 5, max = 250, message = "Text must be between 5 and 250 characters!")
	private String text;
	
	public Offer()
	{

	}
		
	public Offer(int id, String name, String email, String text)
	{
		super();
		this.id = id;
		this.name = StringEscapeUtils.unescapeHtml(name);
		this.email = email;
		this.text = text;
	}

	public Offer(String name, String email, String text)
	{
		super();
		this.name =StringEscapeUtils.unescapeHtml(name);
		this.email = email;
		this.text = text;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return StringEscapeUtils.unescapeHtml(name);
	}

	public void setName(String name)
	{
		this.name = StringEscapeUtils.unescapeHtml(name);
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return "OfferDao [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text +
			"]";
	}


}
