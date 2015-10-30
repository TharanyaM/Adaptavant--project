package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class ListName {
	
		@PrimaryKey
		@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
		private Key key;

	@Persistent
	private String name;
	
	@Persistent 
	public ArrayList<ToDO> todolist = new ArrayList<ToDO>();
	public void setToDO(ArrayList<ToDO> todo) {
		System.out.println("got in");
		this.todolist=todo;
	}

	 public List<ToDO> getToDO() {
		return todolist;
	}

	public void setListName(String listName) {
		this.name = listName;
	}

	public String getName() {
		return name;
	}
}
