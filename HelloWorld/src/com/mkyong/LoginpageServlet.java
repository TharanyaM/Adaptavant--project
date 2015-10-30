package com.mkyong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginpageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	String name=req.getParameter("user");
	out.print("Hello"+name);
	out.close();
	}
}
