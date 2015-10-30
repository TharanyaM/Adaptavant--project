package com.todo.in;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Table3 {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String name;
	@Persistent
	private String email;
	@Persistent
	private String password;
	@Persistent
    private ArrayList<Table3> table;

	
	
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
	public ArrayList<Table3> getTable()
	{
		return table;
	}

	public  void setTable (ArrayList<Table3> Table )
	{
		this.table=Table;
	}


	

}
