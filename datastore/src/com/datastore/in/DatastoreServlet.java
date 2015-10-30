package com.datastore.in;

import java.io.IOException;

import com.google.appengine.api.datastore.Key;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.Entity;

import java.util.Arrays;
import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


import com.google.appengine.api.datastore.KeyFactory;

import java.util.List;

@SuppressWarnings("serial")
public class DatastoreServlet extends HttpServlet {
	private static final String Entity = null;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		//without identifier allow doublication
		Entity e=new Entity("person");
		e.setProperty("first name","suba");
		e.setProperty("lastnmae","c");
		e.setProperty("email","tharan212@gmail.com");
		ds.put(e);
		
		
		//use identifier
		Entity user=new Entity("user",1);
		user.setProperty("id",1);
		user.setProperty("firstname","tharan");
		user.setProperty("lastname","m");
		user.setProperty("email","tharan@gmail.com");
		user.setProperty("password","tharan");
		ds.put(user);
		Key key=KeyFactory.createKey("user",2);
		System.out.println("key value :"+key);
		//
		/*Entity c1=new Entity("emp1");
		Entity c2=new Entity("emp2");
		Entity c3=new Entity("emp3");
		List(Entity) c=Arrays.asList(c1,c2,c3);
		//List(Entity) e4 = Arrays.asList(e1,e2,e3);
		//ds.put(e4);*/
		
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, welcome to all datastore");
	}

	private void List(String entity2) {
		// TODO Auto-generated method stub
		
	}
}
