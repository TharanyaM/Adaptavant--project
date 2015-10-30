package com.java.log;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class OnServletLogin1Servlet extends HttpServlet  
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
 
		String user=req.getParameter("userName");
		String pass=req.getParameter("userPassword");
		
		pw.print("WELL COME"+" "+user);
 
	
 
	}
 
}