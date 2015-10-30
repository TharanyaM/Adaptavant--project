package com.oauth2in;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Oauth2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
