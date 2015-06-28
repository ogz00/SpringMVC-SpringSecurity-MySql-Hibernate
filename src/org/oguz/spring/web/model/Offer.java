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
	// @Pattern(regexp = ".*\\@.*\\..*", message =
// "This does not appear to be a valid email address")
	@ValidEmail(min = 6)
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
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offer(String name, String email, String text)
	{
		super();
		this.name = name;
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
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer)obj;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (text == null)
		{
			if (other.text != null)
				return false;
		}
		else if (!text.equals(other.text))
			return false;
		return true;
	}


}
