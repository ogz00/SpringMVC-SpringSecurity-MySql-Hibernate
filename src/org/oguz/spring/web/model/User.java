package org.oguz.spring.web.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class User
{
	
	@NotBlank(message="Username cannot be blank")
	@Size(min=8, max=25)
	@Pattern(regexp="^\\w{8,}$")
	private String username;
	
	@NotBlank(message="Password cannot be blank")
	@Pattern(regexp="^\\S+$")
	@Size(min=5, max =25)
	private String password;
	
	@Email
	private String email;
	
	private boolean enabled = false;
	private String authority;
	

	public User()
	{
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, boolean enabled, String authority)
	{
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	

}
