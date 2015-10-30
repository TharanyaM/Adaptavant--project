package com.jdo.in;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Table2 {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private Date date;
	@Persistent
	private String name;
	@Persistent
	private String email;
	public String getName() {
		return name;

	}

	public void setName(String Name) {
		this.name = Name;
	}
	public String getEmail() {
		return email;

	}

	public void setEmail(String table1Email) {
		this.email = table1Email;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date table2Date) {
		this.date = table2Date;
	}

}
