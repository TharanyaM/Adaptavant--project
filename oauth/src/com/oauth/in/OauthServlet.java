package com.oauth.in;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OauthServlet {
	@RequestMapping(value = "/")
	public String createForm() {
		return "index";
	}

	@RequestMapping(value = "/oauth1", method = RequestMethod.GET)
	public ModelAndView helloWorld(@RequestParam("code") String code,
			HttpServletRequest req, HttpServletResponse res) throws IOException, ParseException {

		
		System.out.println(code);
		String redirect_url = "http://localhost:8888/oauth1";
		String clientId = "444826947556-h8mut1gide92n3qneri26hl8vde6nbdn.apps.googleusercontent.com";
		String clientSecret = "ddLPGpPYiCK3QyBN1P15-mnH";

		String grant_type = "authorization_code";
		return null;

	}
}
