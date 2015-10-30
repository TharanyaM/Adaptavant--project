package com.jdo.in;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Register {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String email;
	@Persistent
	private String password;
	@Persistent
	private String reenterpassword;
	@Persistent
	private String name;
	
	public String getName() {
		return name;

	}

	public void setName(String Name) {
		this.name = Name;
	}
	
	public String getEmail() {
		return email;

	}

	public void setEmail(String Email) {
		this.email = Email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String Password)
	{
		this.password=Password;
	}
	public String getReEnterPassword()
	{
		return reenterpassword;
	}
	public void setReEnterPassword(String reenterPassword)
	{
		this.reenterpassword=reenterPassword;
	}

	
	
}
