package com.proj.in.controllers;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.datanucleus.api.jdo.exceptions.ClassNotPersistenceCapableException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;







import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.proj.in.models.*;
//import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.google.appengine.labs.repackaged.org.json.JSONObject;
//import com.google.gson.Gson;
import com.proj.in.PMF;

@Controller
public class RegistrationServlet {
	@RequestMapping(value="/signup",method = RequestMethod.GET)
	public String signup()
	{
		return "signup";
		
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/oauth", method = RequestMethod.GET)
	public String openAuthorization(@RequestParam("code") String code,
			HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws IOException, ParseException, java.text.ParseException,
	
				ClassNotPersistenceCapableException, ServletException, org.json.simple.parser.ParseException, JSONException {
		
		String param1 = "value1";
		String param2 = "value2";

		// for get authorization code
		String query = String.format("param1=%s&param2=%s",
				URLEncoder.encode(param1, "UTF-8"),
				URLEncoder.encode(param2, "UTF-8"));
		String redirect_url = "http://localhost:8888/oauth";
		String clientId = "482631779289-nogvfvhsce52astjajqnh526ia4a75e0.apps.googleusercontent.com";
		String clientSecret = "eHfeqw_GLcdD4ILqI-qGBQzZ";

		String grant_type = "authorization_code";
		// for get token_access
		URLConnection connection = new URL(
				"https://www.googleapis.com/oauth2/v3/token?client_id="
						+ clientId + "&client_secret=" + clientSecret
						+ "&redirect_uri=" + redirect_url + "&grant_type="
						+ grant_type + "&code=" + code).openConnection();
		connection.setDoOutput(true); // Triggers POST.
		// connection.setRequestProperty("Accept-Charset", "UTF-8");
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=");
		String charset = "UTF-8";
		try (OutputStream output = connection.getOutputStream()) {
			output.write(query.getBytes(charset));
		}

		InputStream response = connection.getInputStream();
		System.out.println(response);
		StringBuilder str = new StringBuilder();
		//Gson gson = new Gson();
		//String pro = null;
		for (int c1 = response.read(); c1 != -1; c1 = response.read()) {
			char j = (char) c1;
			str.append((char) j);

		}
		String s = str.toString();
		JSONObject json = (JSONObject) new JSONParser().parse(s);
		String access_token = json.get("access_token").toString();
		System.out.println(json.get("access_token"));
		response.close();

		// for get user info
		URLConnection conn = new URL(
				"https://www.googleapis.com/oauth2/v3/userinfo?access_token="
						+ access_token).openConnection();
		conn.setDoOutput(true); // Triggers POST.
		// connection.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=");

		try (OutputStream output1 = conn.getOutputStream()) {
			output1.write(query.getBytes(charset));
		}
		StringBuilder str1 = new StringBuilder();
		InputStream resp = conn.getInputStream();
		for (int c = resp.read(); c != -1; c = resp.read()) {
			char j = (char) c;
			str1.append((char) j);

		}
		String userInfo = new String(str1);
		System.out.println(str1);
		JSONObject j = (JSONObject) new JSONParser().parse(userInfo);
		System.out.println(j.get("picture"));
		String userEmail = (String) j.get("email");
		System.out.println(userEmail);
		String pic = (String) j.get("picture");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String uEmail = req.getParameter("email");
		List<User> result = null;
		javax.jdo.Query q1 = pm.newQuery(User.class);
		q1.setFilter("email =='" + userEmail + "'");
		result = (List<User>) q1.execute();
		System.out.println("" + result);
		if (!result.isEmpty()) {
			Iterator<User> iter = result.iterator();
			while (iter.hasNext()) {
				User currentUser = (User) iter.next();
				if (currentUser.getEmail().equals(userEmail))
				{
					session.setAttribute("user", currentUser);
					return "redirect:/todolist";
				}
			}
			
		} else {
			System.out.println("---------------------");
			User user = new User();
			TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
			Calendar cal = Calendar.getInstance(TimeZone.getDefault());
			Date date = cal.getTime();
			user.setDate(date);
			user.setEmail(userEmail);
			user.setPicture(pic);
			pm.makePersistent(user);
			session.setAttribute("user", user);
			return "redirect:/confirmation";
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value="/confirmation", method=RequestMethod.GET)
	public String Confirmation(ModelMap model, HttpServletRequest req, HttpSession session) {
		model.addAttribute("user", (User)session.getAttribute("user"));
		return "confirmation";
	}
}