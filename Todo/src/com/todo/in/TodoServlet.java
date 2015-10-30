package com.todo.in;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;



@SuppressWarnings("serial")
public class TodoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, InputMismatchException {
		PrintWriter out=resp.getWriter();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, InputMismatchException {
		PrintWriter out=resp.getWriter();
		
	       String email = req.getParameter("email");
	        String password = req.getParameter("password");
	        out.println(email + " " + password);
	       StuDetails sd = new StuDetails();
	        sd .setName("Important");
	        sd.setEmail(email);
	        sd.setPassword(password);
	        String table1=req.getParameter("Table1");
	        //
	        Table1 ta=new Table1();
	        ta.setName("Starred");
	        ta.setEmail(email);
	        ta.setPassword(password);
	        ArrayList<Table1> Table1=new ArrayList<Table1>();
	        Table1.add(ta);
	        sd.setTable1(Table1);
	        //
	        Table2 ta1=new Table2();
	        ta1.setName("If i have time");
	        ta1.setEmail(email);
	        ta1.setPassword(password);
	        ArrayList<Table2> Table2=new ArrayList<Table2>();
	        Table2.add(ta1);
	        ta.setTable2(Table2);
	        PersistenceManager pm = PMF.get().getPersistenceManager();
	       pm.makePersistent(sd);	        
	       // Id used to get details
	     /*
	      * Object oid=pm.getObjectById(sd);
	      System.out.println(oid);*/
	      Query q = pm.newQuery(StuDetails.class,
                   "email == '"+email+"'");
q.declareParameters("String NameParam");


List<StuDetails> results = (List<StuDetails>) q.execute(email);
if (results.size() > 0) {
	StuDetails std = results.get(0);
	out.print(std);
	if (std.getPassword().equals(password)) {
		out.println("Login succesfully!");
	} else {
		out.println("Invalid Password or Email.");
	}
}

}
}
