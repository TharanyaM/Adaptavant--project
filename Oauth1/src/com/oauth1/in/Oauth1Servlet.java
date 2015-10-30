package com.oauth1.in;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.*;

import org.json.simple.parser.*;
import org.json.simple.*;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Oauth1Servlet {
	
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public ModelAndView helloWorld(@RequestParam("code") String code,
			HttpServletRequest req, HttpServletResponse res) throws IOException,ParseException{
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
		//System.out.println(response);
		StringBuilder str = new StringBuilder();
				for (int c1 = response.read(); c1 != -1; c1 = response.read()) {
		char j = (char) c1;
		str.append((char) j);

		}
		String s=new String(str);
		JSONObject json = (JSONObject)new JSONParser().parse(s);
		System.out.println(json.get("access_token"));
			
		response.close();
		
		  URLConnection conn = new
		  URL("https://www.googleapis.com/oauth2/v3/userinfo?token"+ code
		  ).openConnection(); conn.setDoOutput(true); // Triggers POST.
		  //connection.setRequestProperty("Accept-Charset", "UTF-8");
		  conn.setRequestProperty("Content-Type",
		  "application/x-www-form-urlencoded;charset=" );
		  
		  try (OutputStream output = connection.getOutputStream()) {
		  output.write(query.getBytes(charset)); }
		  
		  InputStream re = connection.getInputStream(); 
		  for( int c =response.read(); 
				  c != -1; c = response.read() ) 
			  System.out.print((char)c ); 
		  re.close();
		 // ...
		return null;
	}

	@SuppressWarnings("unused")
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}