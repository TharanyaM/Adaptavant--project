package com.servlet.Hello;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("Welcome user");
	}
}
