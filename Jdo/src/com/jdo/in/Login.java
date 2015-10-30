package com.jdo.in;

import java.io.IOException;

import com.google.gson.Gson;
import javax.servlet.ServletRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import org.datanucleus.api.jdo.exceptions.ClassNotPersistenceCapableException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
@Controller
public class Login {
	private StuDetails currentStuDetails;

	@RequestMapping(value = "/")
	public String createForm() {
		return "index";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ModelAndView helloWorld(HttpServletRequest req,
			HttpServletResponse res) throws IOException, ParseException,
			ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
	String eEmail=req.getParameter("email");
	Gson gson = new Gson();
	String data=null;
	List<StuDetails>li1=null;
	Query q=pm.newQuery(StuDetails.class);
	q.setFilter("email == '" + eEmail + "'");
	li1=(List<StuDetails>)q.execute();
	System.out.println("#######"+li1);
	if(!li1.isEmpty())
	{
	Iterator<StuDetails>itera=li1.iterator();
	while(itera.hasNext())
	{
		StuDetails currentStuDetails=(StuDetails)itera.next();
		System.out.println(currentStuDetails.getEmail());
		System.out.println(currentStuDetails.getTable1());
		
	
	ArrayList<Table1>list=(ArrayList<Table1>)currentStuDetails.getTable1();
	Iterator<Table1>itera1=list.iterator();
	System.out.println("----------------");
	System.out.println(currentStuDetails.table1);
	while(itera1.hasNext())
	{
		Table1 current = (Table1) itera1.next();
		ArrayList<Table2> list1 = (ArrayList<Table2>) current.getTable2();
		Iterator<Table2> it1 = list1.iterator();

		System.out.println(current.getEmail());
		while (it1.hasNext()) {
			Table2 curr = (Table2) it1.next();
			System.out.println("------------------");
			System.out.println(curr.getEmail());
			System.out.println("------------------");
		}
	}
	System.out.println(currentStuDetails);
	data= gson.toJson(currentStuDetails);
	}
	}
	else
	{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		Date date = cal.getTime();
	
	StuDetails stu = new StuDetails();
	stu.setEmail(eEmail);
	stu.setDate(date);
	
	//stu.setName(name);
	//stu.setPassword(password);
	Table1 list = new Table1();
	list.setTable1("Important");
	Table2 tab = new Table2();
	tab.setEmail("table two email");
	tab.setDate(date);
	Table2 tab1 = new Table2();
	tab1.setEmail("tharanya21@gmail.com");
	tab1.setDate(date);
	Table2 tab2 = new Table2();
	tab2.setEmail("suba321@gmail.com");
	tab2.setDate(date);
	ArrayList<Table2> tab2email = new ArrayList<Table2>();
	tab2email.add(tab);
	tab2email.add(tab1);
	tab2email.add(tab2);
	list.setTable2(tab2email);

	Table1 list1 = new Table1 ();
	list1.setTable1("Started");
	Table2 tab5 = new Table2();
	tab5.setEmail("suji342@gmail.com");
	tab5.setDate(date);
	Table2 tab6 = new Table2();
	tab6.setEmail("vijaya4326@gmail.com");
	tab6.setDate(date);
	Table2 tab7 = new Table2();
	tab7.setEmail("bhavani76@gmail.com");
	tab7.setDate(date);
	ArrayList<Table2> tab2email1 = new ArrayList<Table2>();
	tab2email1.add(tab5);
	tab2email1.add(tab6);
	tab2email1.add(tab7);
	list1.setTable2(tab2email1);
	
	Table1 list2 = new Table1();
	list2.setTable1("If i have time");
	Table2 tab8 = new Table2();
	tab8.setEmail("srini32@gmail.com");
	tab8.setDate(date);
	Table2 tab9 = new Table2();
	tab9.setEmail("anjany76@gmail.com");
	tab9.setDate(date);
	Table2 tab10 = new Table2();
	tab10.setEmail("tharani5262@gmail.com");
	tab10.setDate(date);
	ArrayList<Table2> table2email2 = new ArrayList<Table2>();
	table2email2.add(tab8);
	table2email2.add(tab9);
	table2email2.add(tab10);
	System.out.println(tab2email);
	list2.setTable2(tab2email1);
	ArrayList<Table1> table1 = new ArrayList<Table1>();
	table1.add(list);
	table1.add(list1);
	table1.add(list2);
	stu.setTable1(table1);

	pm.makePersistent(stu);
	//req.getRequestDispatcher("/register").include(req, res);
	pm.close();
	return new ModelAndView("data", "stu", data);

}

//@SuppressWarnings("unchecked")
//@RequestMapping(value = "/register", method = RequestMethod.GET)
//public ModelAndView hello(HttpServletRequest req, HttpServletResponse res)
		//throws IOException, ParseException, java.text.ParseException,
		//ClassNotPersistenceCapableException,ServletException{
public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException, InputMismatchException {
	PrintWriter out = resp.getWriter();
	
	PersistenceManager pm = PMF.get().getPersistenceManager();
	String eEmail = req.getParameter("email");
	Gson gson = new Gson();
	String data = null;
	List<StuDetails> result = null;
	Query q1 = pm.newQuery(StuDetails.class);
	q1.setFilter("email == '" + eEmail + "'");
	try {
		result = (List<StuDetails>) q1.execute();

		if (result != null) {
			Iterator<StuDetails> it = result.iterator();
			while (it.hasNext()) {
				StuDetails currentStuDetails = (StuDetails) it.next();
				ArrayList<Table1> email = (ArrayList<Table1>) currentStuDetails
						.getTable1();
				Iterator<Table1> iter1 = email.iterator();
				System.out.println("-------------------");
				System.out.println(currentStuDetails.table1);
				while (iter1.hasNext()) {
					Table1 current = (Table1) iter1.next();
					ArrayList<Table2> table2Email = (ArrayList<Table2>) current.getTable2();
					Iterator<Table2> it1 = table2Email.iterator();

					System.out.println(current.getEmail());
					while (it1.hasNext()) {
						Table2 curr = (Table2) it1.next();
						System.out.println("-------------------------");
						System.out.println(curr.getEmail());
						System.out.println("---------------------------");
					}
				}

				data = gson.toJson(currentStuDetails);
			}

		}
	} finally {

		pm.close();

	}
	//return new ModelAndView("data", "user", data);
}

}



	}
	//ArrayList<Table1> list = (ArrayList<Table1>) currStuDetails.getTable1();
	//Iterator<Table1>itera1=list.iterator();
	
	/*String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name=req.getParameter("name");
		String reenterpassword=req.getParameter("reenterpassword");
		out.println(email + " " + password);
		StuDetails sd = new StuDetails();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy - hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		sd.setDate(sdf.format(new Date()));

		sd.setName("Important");
		sd.setEmail(email);
		sd.setPassword(password);
		String table1 = req.getParameter("Table1");
		//
		Table1 ta = new Table1();
		ta.setName("Starred");
		ta.setEmail(email);
		ta.setPassword(password);
		ArrayList<Table1> Table1 = new ArrayList<Table1>();
		Table1.add(ta);
		sd.setTable1(Table1);
		//
		Table2 ta1 = new Table2();
		ta1.setName("If i have time");
		ta1.setEmail(email);
		ta1.setPassword(password);
		ArrayList<Table2> Table2 = new ArrayList<Table2>();
		Table2.add(ta1);
		ta.setTable2(Table2);
		//
		Table3 ta2 = new Table3();
		ta2.setName("If i have time");
		ta2.setEmail(email);
		ta2.setPassword(password);
		ArrayList<Table3> Table3 = new ArrayList<Table3>();
		Table3.add(ta2);
		ta1.setTable3(Table3);

		pm.makePersistent(sd);
		Query q = pm.newQuery(StuDetails.class);
		q.setFilter("email == '" + email + "'");
		
		

		// Id used to get details
		/*
		 * Object oid=pm.getObjectById(sd); System.out.println(oid);
		 */
		/*Query q = pm.newQuery(StuDetails.class, "email == '" + email + "'");
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
		}*/

	

