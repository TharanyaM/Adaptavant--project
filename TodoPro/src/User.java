package com.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private Long id;

	@Persistent
	private String name;

	@Persistent
	private String pic;

	@Persistent
	private Date date;

	@Persistent
	public ArrayList<ListName> listname = new ArrayList<ListName>();

	// getter and setter methods

	public void setListName(ArrayList<ListName> list) {
		System.out.println("got in");
		this.listname = list;
	}

	List<ListName> getListName() {
		return listname;
	}

	public void setId(long key2) {
		this.id = key2;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getPicture() {
		return pic;
	}

	public void setPicture(String pic) {
		this.pic = pic;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date hireDate) {
		this.date = hireDate;
	}

}